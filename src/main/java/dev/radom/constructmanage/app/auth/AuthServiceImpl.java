package dev.radom.constructmanage.app.auth;

import dev.radom.constructmanage.app.auth.web.*;
import dev.radom.constructmanage.app.mail.Mail;
import dev.radom.constructmanage.app.mail.MailService;
import dev.radom.constructmanage.app.user.User;
import dev.radom.constructmanage.app.user.service.UserService;
import dev.radom.constructmanage.app.user.web.AddNewUserDto;
import dev.radom.constructmanage.utils.RandomCode;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final AuthMapper authMapper;
    private final AuthRepository authRepository;
    private final MailService mailService;
    @Value("${spring.mail.username}")
    private String adminMail;
    private final DaoAuthenticationProvider daoAuthenticationProvider;
    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    private final JwtEncoder jwtEncoder;
    private JwtEncoder jwtRefreshTokenEncoder;

    @Autowired
    void setJwtRefreshTokenEncoder(@Qualifier("refreshTokenJwtEncoder") JwtEncoder jwtRefreshTokenEncoder) {
        this.jwtRefreshTokenEncoder = jwtRefreshTokenEncoder;
    }

    @PreAuthorize("hasAuthority('SCOPE_refresh_token')")

    @Override
    public AuthDto refreshToken(RefreshTokenDto refreshTokenDto) {
        Authentication auth = new BearerTokenAuthenticationToken(refreshTokenDto.refreshToken());
        auth = jwtAuthenticationProvider.authenticate(auth);

        Jwt jwt = (Jwt) auth.getPrincipal();
        log.info("Jwt Name = {}", jwt.getId());
        log.info("Jwt Subject = {}", jwt.getSubject());

        return AuthDto.builder()
                .type("Bearer")
                .accessToken(generateAccessToken(GenerateTokenDto.builder()
                        .auth(jwt.getId())
                        .scope(jwt.getClaimAsString("scope"))
                        .expiration(Instant.now().plus(1, ChronoUnit.DAYS))
                        .build()))
                .refreshToken(generateRefreshTokenCheckDuration(GenerateTokenDto.builder()
                        .auth(jwt.getId())
                        .scope(jwt.getClaimAsString("scope"))
                        .previousToken(refreshTokenDto.refreshToken())
                        .expiration(Instant.now().plus(30, ChronoUnit.DAYS))
                        .duration(Duration.between(Instant.now(), jwt.getExpiresAt()))
                        .checkDurationNumber(7)
                        .build()))
                .build();
    }

    private String generateAccessToken(GenerateTokenDto generateTokenDto) {
        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .id(generateTokenDto.auth())
                .issuer("public")
                .issuedAt(Instant.now())
                .expiresAt(generateTokenDto.expiration())
                .subject("Access Token")
                .audience(List.of("Public Client"))
                .claim("scope", generateTokenDto.scope())
                .build();
        return jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();
    }

    private String generateRefreshToken(GenerateTokenDto generateTokenDto) {
        JwtClaimsSet jwtRefreshTokenClaimsSet = JwtClaimsSet.builder()
                .id(generateTokenDto.auth())
                .issuer("public")
                .issuedAt(Instant.now())
                .expiresAt(generateTokenDto.expiration())
                .subject("Refresh Token")
                .audience(List.of("Public Client"))
                .claim("scope", generateTokenDto.scope())
                .build();
        return jwtRefreshTokenEncoder.encode(JwtEncoderParameters.from(jwtRefreshTokenClaimsSet)).getTokenValue();
    }


    private String generateRefreshTokenCheckDuration(GenerateTokenDto generateTokenDto) {
        log.info("Duration : {}", generateTokenDto.duration().toDays());
        if (generateTokenDto.duration().toDays() < generateTokenDto.checkDurationNumber()) {
            JwtClaimsSet jwtRefreshTokenClaimsSet = JwtClaimsSet.builder()
                    .id(generateTokenDto.auth())
                    .issuer("public")
                    .issuedAt(Instant.now())
                    .expiresAt(generateTokenDto.expiration())
                    .subject("Refresh Token")
                    .audience(List.of("Public Client"))
                    .claim("scope", generateTokenDto.scope())
                    .build();
            return jwtRefreshTokenEncoder.encode(JwtEncoderParameters.from(jwtRefreshTokenClaimsSet)).getTokenValue();
        }
        return generateTokenDto.previousToken();
    }

    @Override
    public AuthDto login(LoginDto loginDto) {
        Authentication auth = new UsernamePasswordAuthenticationToken(loginDto.username(), loginDto.password());
        auth = daoAuthenticationProvider.authenticate(auth);

        log.info("AUTH = {}", auth.getName());
        log.info("AUTH = {}", auth.getAuthorities());

        String scope = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        return AuthDto.builder()
                .type("Bearer")
                .accessToken(generateAccessToken(GenerateTokenDto.builder()
                        .auth(auth.getName())
                        .scope(scope)
                        .expiration(Instant.now().plus(1, ChronoUnit.DAYS))
                        .build()))
                .refreshToken(generateRefreshToken(GenerateTokenDto.builder()
                        .auth(auth.getName())
                        .scope(scope)
                        .expiration(Instant.now().plus(30, ChronoUnit.DAYS))
                        .build()))
                .build();
    }

    @Transactional
    @Override
    public void register(RegisterDto registerDto) {
        AddNewUserDto newUserDto = authMapper.mapRegisterDtoToNewUserDto(registerDto);
        userService.addNewUser(newUserDto);
        String verifiedCode = RandomCode.generateCode();
        //Store verifiedCode in database
        authRepository.updateVerifiedCode(registerDto.username(), verifiedCode);
        //Send verifiedCode via email
        Mail<String> verifiedMail = new Mail<>();
        verifiedMail.setSubject("Email Verification");
        verifiedMail.setSender(adminMail);
        verifiedMail.setReceiver(newUserDto.email());
        verifiedMail.setTemplate("auth/verify-mail");
        verifiedMail.setMetaData(verifiedCode);
        try {
            mailService.sendMail(verifiedMail);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void verify(VerifyDto verifyDto) {
        log.info("verifyDto: {}",verifyDto);
        User verifiedUser = authRepository.findByEmailAndVerifiedCodeAndIsDeletedFalse(verifyDto.email(), verifyDto.verifiedCode())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED,
                        "Verify email has been failed..!"
                ));
        log.info("verifiedUser:{}",verifiedUser);
        verifiedUser.setIsVerified(true);
        verifiedUser.setVerifiedCode(null);
        authRepository.save(verifiedUser);
    }
}
