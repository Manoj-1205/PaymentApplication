package com.systemdesign.paymentapplication.configs;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;


//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable())  // ✅ Correct: Lambda syntax
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/payments/**").permitAll()
//                        .requestMatchers("/api/wallets/**").permitAll()
//                        .requestMatchers("/api/users/**").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .httpBasic(basic -> {
//                });  // ✅ Correct: Lambda syntax
//
//        return http.build();
//    }
//}