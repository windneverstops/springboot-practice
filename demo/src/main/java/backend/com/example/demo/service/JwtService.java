package backend.com.example.demo.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {
    private static final String SECRET_KEY = "your_secret_key";  // Use a secure key!

    // Generate JWT token
    public String generateToken(String email) {
        return Jwts.builder()
                .subject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000*4)) // 24 hours
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // Validate JWT token
    public Claims validateToken(String token) {
        return Jwts.builder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    // Extract email (or other claim) from token
    public String extractEmail(String token) {
        return validateToken(token).getSubject();
    }

    // Check if token is expired
    public boolean isTokenExpired(String token) {
        return validateToken(token).getExpiration().before(new Date());
    }
}
