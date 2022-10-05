package com.my.app.security;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.my.app.security.ApplicationUserRoles.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers(HttpMethod.POST, "/management/api/v1/**").hasAuthority(ApplicationUserPermissions.COURSES_WRITE.name())
                .antMatchers(HttpMethod.PUT, "/management/api/v1/**").hasAuthority(ApplicationUserPermissions.COURSES_WRITE.name())
                .antMatchers(HttpMethod.DELETE, "/management/api/v1/**").hasAuthority(ApplicationUserPermissions.COURSES_WRITE.name())
                .antMatchers(HttpMethod.GET, "/management/api/v1/**").hasAuthority(ApplicationUserPermissions.COURSES_WRITE.name())
                .antMatchers("/api/v1/student/**").hasRole(STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails adminShehroz = User.builder()
                .username("shehroz")
                .password(passwordEncoder.encode("shehroz"))
                .authorities(ADMIN.getGrantedAuthorities())
//                .roles(ADMIN.name())
                .build();

        UserDetails studentAli = User.builder()
                .username("ali")
                .password(passwordEncoder.encode("ali"))
                .authorities(STUDENT.getGrantedAuthorities())
//                .roles(STUDENT.name())
                .build();

        UserDetails adminTraineeSaad = User.builder()
                .username("saad")
                .password(passwordEncoder.encode("saad"))
                .authorities(ADMINTRAINEE.getGrantedAuthorities())
//                .roles(ADMINTRAINEE.name())
                .build();

        return new InMemoryUserDetailsManager(
                adminShehroz,
                adminTraineeSaad,
                studentAli
        );
    }
}
