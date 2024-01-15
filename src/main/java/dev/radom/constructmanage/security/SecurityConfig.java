package dev.radom.constructmanage.security;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import dev.radom.constructmanage.utils.KeyUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.security.web.SecurityFilterChain;

import java.util.UUID;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final KeyUtil keyUtil;

    @Bean
    JwtAuthenticationProvider jwtAuthenticationProvider() {
        return new JwtAuthenticationProvider(jwtRefreshTokenDecoder());
    }

    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //What you want to customize
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/v1/auth/**", "/api/v1/files/**", "/file/**", "/auth/**").permitAll()

                .requestMatchers(HttpMethod.GET, "/api/v1/jobs/**").hasAuthority("SCOPE_job:read")
                .requestMatchers(HttpMethod.GET, "/api/v1/clients/**").hasAuthority("SCOPE_client:read")
                .requestMatchers(HttpMethod.GET, "/api/v1/projects/**").hasAuthority("SCOPE_project:read")
                .requestMatchers(HttpMethod.GET, "/api/v1/employees/**").hasAuthority("SCOPE_project:read")
                .requestMatchers(HttpMethod.GET, "/api/v1/assignments/**").hasAuthority("SCOPE_assignment:read")

                .requestMatchers(HttpMethod.POST, "/api/v1/jobs/**").hasAuthority("SCOPE_job:write")
                .requestMatchers(HttpMethod.POST, "/api/v1/clients/**").hasAuthority("SCOPE_client:write")
                .requestMatchers(HttpMethod.POST, "/api/v1/projects/**").hasAuthority("SCOPE_project:write")
                .requestMatchers(HttpMethod.POST, "/api/v1/employees/**").hasAuthority("SCOPE_project:write")
                .requestMatchers(HttpMethod.POST, "/api/v1/assignments/**").hasAuthority("SCOPE_assignment:write")

                .requestMatchers(HttpMethod.PUT, "/api/v1/jobs/**").hasAuthority("SCOPE_job:update")
                .requestMatchers(HttpMethod.PUT, "/api/v1/clients/**").hasAuthority("SCOPE_client:update")
                .requestMatchers(HttpMethod.PUT, "/api/v1/projects/**").hasAuthority("SCOPE_project:update")
                .requestMatchers(HttpMethod.PUT, "/api/v1/employees/**").hasAuthority("SCOPE_project:update")
                .requestMatchers(HttpMethod.PUT, "/api/v1/assignments/**").hasAuthority("SCOPE_assignment:update")

                .requestMatchers(HttpMethod.DELETE, "/api/v1/jobs/**").hasAuthority("SCOPE_job:delete")
                .requestMatchers(HttpMethod.DELETE, "/api/v1/clients/**").hasAuthority("SCOPE_client:delete")
                .requestMatchers(HttpMethod.DELETE, "/api/v1/projects/**").hasAuthority("SCOPE_project:delete")
                .requestMatchers(HttpMethod.DELETE, "/api/v1/employees/**").hasAuthority("SCOPE_project:delete")
                .requestMatchers(HttpMethod.DELETE, "/api/v1/assignments/**").hasAuthority("SCOPE_assignment:delete")

                .requestMatchers(HttpMethod.GET, "/api/v1/users/me").hasAuthority("SCOPE_user:profile")
                .requestMatchers(HttpMethod.GET, "/api/v1/users/**").hasAuthority("SCOPE_user:read")
                .requestMatchers(HttpMethod.POST, "/api/v1/users/**").hasAuthority("SCOPE_user:write")
                .requestMatchers(HttpMethod.DELETE, "/api/v1/users/**").hasAuthority("SCOPE_user:delete")
                .requestMatchers(HttpMethod.PUT, "/api/v1/users/**").hasAuthority("SCOPE_user:update")

//                .requestMatchers("/swagger-ui.html",
//                        "/swagger-ui/**",
//                        "/v3/api-docs/**",
//                        "/v3/api-docs/**",
//                        "/swagger-resources",
//                        "/swagger-resources/**",
//                        "/configuration/security",
//                        "/swagger-ui",
//                        "/webjars/**"
//                ).permitAll()
                .anyRequest().authenticated());
        //TODO: User default form login
        //http.formLogin(Customizer.withDefaults());

        // TODO: Configure JWT | OAuth2 Resource Server.
        http.oauth2ResourceServer(oauth2 ->
                oauth2.jwt(Customizer.withDefaults())
        );
        http.csrf(AbstractHttpConfigurer::disable);//http.csrf(token -> token.disable());

        //TODO: Update API policy to STATELESS
        http.sessionManagement(session ->
                session.sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS
                ));
        return http.build();

    }


    @Bean
    @Primary
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(keyUtil.getAccessTokenPublicKey()).build();
    }

    @Bean
    @Primary
    JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwkSource) {
        return new NimbusJwtEncoder(jwkSource);
    }

    @Bean
    @Primary
    public JWKSource<SecurityContext> jwkSource() {
        JWK jwk = new RSAKey.Builder(keyUtil.getAccessTokenPublicKey())
                .privateKey(keyUtil.getAccessTokenPrivateKey())
                .keyID(UUID.randomUUID().toString())
                .build();
        var jwkSet = new JWKSet(jwk);
        return (jwkSelector, context) -> jwkSelector.select(jwkSet);
    }

    @Bean(name = "refreshTokenJwtEncoder")
    JwtEncoder refreshTokenJwtEncoder(@Qualifier("refreshTokenJWKSource") JWKSource<SecurityContext> jwkSource) {
        return new NimbusJwtEncoder(jwkSource);
    }

    @Bean("jwtRefreshTokenDecoder")
    JwtDecoder jwtRefreshTokenDecoder() {
        return NimbusJwtDecoder.withPublicKey(keyUtil.getRefreshTokenPublicKey()).build();
    }

    @Bean(name = "refreshTokenJWKSource")
    public JWKSource<SecurityContext> refreshTokenjwkSource() {
        JWK jwk = new RSAKey.Builder(keyUtil.getRefreshTokenPublicKey())
                .privateKey(keyUtil.getRefreshTokenPrivateKey())
                .keyID(UUID.randomUUID().toString())
                .build();
        var jwkSet = new JWKSet(jwk);
        return (jwkSelector, context) -> jwkSelector.select(jwkSet);
    }

}
