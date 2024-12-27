package backend.com.example.demo.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.server.Cookie;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {
    private static final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();
    private static final String COOKIE_NAME = "JWT_TOKEN";
    // Generate JWT token
    public String generateToken(long id) {
        return Jwts.builder()
                .subject(Long.toString(id))
                .signWith(SECRET_KEY)
                .compact();
    }

    public void addJwtToCookie(String jwtToken, HttpServletResponse response) {
        /* Cookie jwtCookie = new Cookie(COOKIE_NAME, jwtToken);
        jwtCookie.setHttpOnly(true); // Make the cookie inaccessible to JavaScript
        jwtCookie.setSecure(true); // Only send cookie over HTTPS
        jwtCookie.setPath("/"); // Make the cookie available to the entire application
        jwtCookie.setMaxAge(3600); // Set expiration time (1 hour)
        jwtCookie.setSameSite("Strict"); // Prevent cross-site request forgery

        response.addCookie(jwtCookie); */
    }

    // Validate JWT token
    public Claims validateToken(String token) {
        return Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

}
