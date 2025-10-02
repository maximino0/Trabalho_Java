//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((auth) -> ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)auth.requestMatchers(new String[]{"/cadastro", "/", "/usuarios", "/css/**"})).permitAll().anyRequest()).authenticated()).formLogin((form) -> ((FormLoginConfigurer)form.loginPage("/").defaultSuccessUrl("/Home", true)).permitAll()).logout((logout) -> logout.logoutUrl("/logout").logoutSuccessUrl("/").permitAll());
        return (SecurityFilterChain)http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository repository) {
        return (usernameOrEmail) -> {
            User userEntity = repository.findByUsernameOrEmail(usernameOrEmail);
            if (userEntity == null) {
                throw new UsernameNotFoundException("Usuário não encontrado");
            } else {
                org.springframework.security.core.userdetails.User.UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(userEntity.getUsername());
                builder.password("{noop}" + userEntity.getPassword());
                builder.roles(new String[]{"USER"});
                return builder.build();
            }
        };
    }
}
