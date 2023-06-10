package br.com.alura.aluramed.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    
    @Autowired
    private SecurityFilter securityFilter;
    
    //desabilitado CSRF
    //habilitando o modelo stateless
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and().authorizeHttpRequests()
            .requestMatchers(HttpMethod.POST, "/login").permitAll()
            .requestMatchers( "/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll()
            .anyRequest().authenticated()
            .and().addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
    }


    //Ensina o spring a injetar o objeto
    @Bean
    public AuthenticationManager AuthenticationManager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
