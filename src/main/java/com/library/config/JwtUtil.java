package com.library.config;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import io.jsonwebtoken.Claims;

@Component
public class JwtUtil {
    private String secretKey = "Libr@rym@n@gement@pplic@tion97531";
    private Key key = Keys.hmacShaKeyFor(secretKey.getBytes());

    public String generateToken(String username, String role) {
        return Jwts.builder()
                .setSubject(username)              // who this token belongs to
            .claim("role",role)           // extra custom data — the role
            .setIssuedAt(new Date())      // when it was created — "now"
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour from now
                .signWith(key, SignatureAlgorithm.HS256)  // actually sign it with our key
                .compact();                   // finalize into the xxxxx.yyyyy.zzzzz string
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractUsername(String token){
        return getClaims(token).getSubject();
    }
    public String extractRole(String token){
        return (String) getClaims(token).get("role");
    }
    public boolean isTokenValid(String token){
        try{
            getClaims(token);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
