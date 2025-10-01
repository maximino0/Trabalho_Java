package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/cadastro", "/","/usuarios", "/css/**").permitAll() // rotas públicas
                        .anyRequest().authenticated() // todas as outras rotas precisam de login
                )
                .formLogin(form -> form
                        .loginPage("/")             // rota de login personalizada
                        .defaultSuccessUrl("/Home", true) // rota após login
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")       // volta pro login após logout
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository repository) {
        return usernameOrEmail -> {
            User userEntity = repository.findByUsernameOrEmail(usernameOrEmail);
            if (userEntity == null) {
                throw new UsernameNotFoundException("Usuário não encontrado");
            }

            UserBuilder builder = org.springframework.security.core.userdetails.User
                    .withUsername(userEntity.getUsername());
            builder.password("{noop}" + userEntity.getPassword()); // sem criptografia
            builder.roles("USER");
            return builder.build();
        };
    }
}
