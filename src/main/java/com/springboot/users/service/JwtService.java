package com.springboot.users.service;
// package com.webknot.users.service;

// import java.util.Date;
// import java.util.function.Function;

// import javax.crypto.SecretKey;

// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.stereotype.Service;

// import com.webknot.users.model.Employee;
// import com.webknot.users.model.User;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.io.Decoders;
// import io.jsonwebtoken.security.Keys;

// @Service
// public class JwtService {
    
//     private final String SECRET_KEY ="5d7381fb44733a39ac9bc29f671d2253139bdbf53df0aeda55b68c44507f06b2";

//     public String generateToken(User user){
//         String token = Jwts
//             .builder()
//             .subject(user.getUserName())
//             .issuedAt(new Date(System.currentTimeMillis()))
//             .expiration(new Date(System.currentTimeMillis() + 24*60*60*1000))
//             .signWith(getSignKey())
//             .compact();

//         return token;
//     }
    
//     private Claims extractAllClaims(String token){
//         return Jwts
//             .parser()
//             .verifyWith(getSignKey())
//             .build()
//             .parseSignedClaims(token)
//             .getPayload();

//     }

//     public <T> T extractClaim(String token, Function<Claims, T> resolver){
//         Claims claims = extractAllClaims(token);
//         return resolver.apply(claims);
//     }

//     public String extractUsername(String token) {
//         return extractClaim(token, Claims::getSubject);
//     }

//     public boolean isValid(String token, UserDetails user) {
//         String username = extractUsername(token);
//         return (username.equals(user.getUsername())) && !isTokenExpired(token);
//     }

//     private boolean isTokenExpired(String token) {
//         return extractExpiration(token).before(new Date());
//     }

//     private Date extractExpiration(String token) {
//         return extractClaim(token, Claims::getExpiration);
//     }

//     private SecretKey getSignKey() {
        
//         byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);
//         return Keys.hmacShaKeyFor(keyBytes);
//     }

//     public String generateToken(Employee emp) {
 
//         throw new UnsupportedOperationException("Unimplemented method 'generateToken'");
//     }

// }
