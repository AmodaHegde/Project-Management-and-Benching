package com.springboot.users.service;
// package com.webknot.users.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Lazy;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// @Service
// public class CommonService {
    
//     private AuthenticationManager authenticationManager;

//     public AuthenticationManager getAuthenticationManager() {
//         return authenticationManager;
//     }

//     private PasswordEncoder passwordEncoder;

//     public PasswordEncoder getPasswordEncoder() {
//         return passwordEncoder;
//     }

//     @Autowired
//     public CommonService(@Lazy PasswordEncoder passwordEncoder,@Lazy AuthenticationManager authenticationManager) {
//         this.passwordEncoder = passwordEncoder;
//         this.authenticationManager = authenticationManager;
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder(){
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
//         return configuration.getAuthenticationManager();
//     }
    

// }
