package com.sparta.wahdel.nbastatsspringproject.security;

import com.sparta.wahdel.nbastatsspringproject.service.LoginCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final LoginCredentialService loginCredentialService;
    private final PasswordEncryptor passwordEncryptor;

    @Autowired
    public WebSecurityConfig(LoginCredentialService loginCredentialService, PasswordEncryptor passwordEncryptor) {
        this.loginCredentialService = loginCredentialService;
        this.passwordEncryptor = passwordEncryptor;
    }

    @Bean
    public AuthenticationManager getAuthenticationManager() throws Exception{
        return authenticationManager();
    }

    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/verifyAddedPlayers?")
                .hasAnyRole("ROLE_USER", "ROLE_ADMIN")
                .antMatchers("/createAccount")
                .access("not (hasRole('ROLE_USER'))")
                .antMatchers("/", "/index", "/players/**", "/teams/**", "/fantasyTeams")
                .permitAll()
                .anyRequest()
                .authenticated() // (4)
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity.ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/webjars/**");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginCredentialService).passwordEncoder(passwordEncryptor.getBCryptPasswordEncoder());
    }
}