package yes1sir.yessir.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenGenerator {

    @Value("${jwt.secret-key}")
    private String secretKey;
    @Value("${jwt.expire-length}")
    private long expireTimeMilliSecond;

    public String generateToken(final String id) {
        final Claims claims = Jwts.claims().setSubject(id);
        claims.put("memberId", id);
        final Date now = new Date();
        final Date expiredDate = new Date(now.getTime() + expireTimeMilliSecond);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiredDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public String extractMemberId(final String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody()
                    .get("memberId", String.class);
        } catch (final Exception error) {
            throw new RuntimeException("INVALID_ACCESS_TOKEN", error);
        }
    }
}
