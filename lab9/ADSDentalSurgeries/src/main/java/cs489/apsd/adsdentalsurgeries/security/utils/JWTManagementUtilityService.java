package cs489.apsd.adsdentalsurgeries.security.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTManagementUtilityService {
    public static final String SECRET = "SuperSecretKeyForADSDentalSurgeriesUtilityService";

    private String createToken(Map<String, Object> claims, String subject) {
        var now = Instant.now();
        return Jwts.builder()
                .claims()
                .subject(subject)
                .add(claims)
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plus(24, ChronoUnit.HOURS)))
                .and()
                .signWith(getSignKey())
                .compact();
    }

    private SecretKey getSignKey() {
        byte [] keys = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keys);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())
                && !isTokenExpired(token));
    }
}
