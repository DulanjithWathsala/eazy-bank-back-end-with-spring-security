package edu.eazybank.spring_security.config;

import edu.eazybank.spring_security.config.exception.handler.CustomAccessDeniedHandler;
import edu.eazybank.spring_security.config.exception.handler.CustomBasicAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@Profile("prod")
public class ProjectSecurityProdConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .sessionManagement(sessionManagementConfig -> sessionManagementConfig.invalidSessionUrl("/invalidSession")
                        .maximumSessions(1).maxSessionsPreventsLogin(true))
                .requiresChannel(requiresChannelConfig -> requiresChannelConfig.anyRequest().requiresSecure()) // Only accept HTTPS requests
                .csrf(csrfConfig -> csrfConfig.disable())
                .authorizeHttpRequests(requests -> requests
                .requestMatchers("/account", "/balance", "/cards", "/loans").authenticated()
                .requestMatchers("/contact", "/notices", "/user/register", "/error", "/invalidSession").permitAll());
        http.formLogin(withDefaults());
        http.httpBasic(httpBasicConfig ->
                httpBasicConfig.authenticationEntryPoint(new CustomBasicAuthenticationEntryPoint()));
        http.exceptionHandling(exceptionHandlingConfig ->
                exceptionHandlingConfig.accessDeniedHandler(new CustomAccessDeniedHandler()));
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public CompromisedPasswordChecker compromisedPasswordChecker() {
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }
}
