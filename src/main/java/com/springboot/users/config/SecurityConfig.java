// package com.webknot.users.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Lazy;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// import com.webknot.users.filter.JwtAuthenticationFilter;
// import com.webknot.users.service.UserService;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     private final UserService userService;

//     private final JwtAuthenticationFilter jwtAuthenticationFilter;

//     public SecurityConfig(@Lazy UserService userService,  JwtAuthenticationFilter jwtAuthenticationFilter) {
//         this.userService = userService;
//         this.jwtAuthenticationFilter = jwtAuthenticationFilter;
//     }

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//         return http 
//             .csrf(AbstractHttpConfigurer::disable)
//             .authorizeHttpRequests(
//                 req->req.requestMatchers("/login/**", "/register/**", "/emp/add/**")
//                 .permitAll()
//                 .requestMatchers("admin-only/**").hasAuthority("ADMIN")
//                 .anyRequest()
//                 .authenticated()
//             ).userDetailsService(userService)
//             .sessionManagement(session -> session
//                 .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//             .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//             .build();
//     }
    
// }

// <dependency>
//     <groupId>io.jsonwebtoken</groupId>
//     <artifactId>jjwt-api</artifactId>
//     <version>0.11.5</version>
// </dependency>
