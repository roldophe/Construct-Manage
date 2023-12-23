package dev.radom.constructmanage.api.auth;

import dev.radom.constructmanage.api.auth.web.LoginDto;
import dev.radom.constructmanage.api.auth.web.RegisterDto;
import dev.radom.constructmanage.api.auth.web.VerifyDto;
import dev.radom.constructmanage.api.mail.Mail;
import dev.radom.constructmanage.api.mail.MailService;
import dev.radom.constructmanage.api.user.User;
import dev.radom.constructmanage.api.user.service.UserService;
import dev.radom.constructmanage.api.user.web.AddNewUserDto;
import dev.radom.constructmanage.utils.GenerateCode;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final AuthMapper authMapper;
    private final AuthRepository authRepository;
    private final MailService mailService;
    @Value("${spring.mail.username}")
    private String adminMail;

    @Transactional
    @Override
    public void register(RegisterDto registerDto){
        AddNewUserDto newUserDto = authMapper.mapRegisterDtoToNewUserDto(registerDto);
        userService.addNewUser(newUserDto);
        String verifiedCode = GenerateCode.generateCode();
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
        User verifiedUser = authRepository.findByEmailAndVerifiedCodeAndIsDeletedFalse(verifyDto.email(), verifyDto.verifiedCode())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED,
                        "Verify email has been failed..!"
                ));
        verifiedUser.setIsVerified(true);
        verifiedUser.setVerifiedCode(null);
        authRepository.save(verifiedUser);
    }
    @Override
    public void login(LoginDto loginDto) {
    }
}