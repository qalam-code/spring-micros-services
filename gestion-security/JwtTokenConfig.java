import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JwtTokenConfig {
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", userDetails.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .toList());

        // Tu peux aussi ajouter des permissions spécifiques ici
        claims.put("permissions", List.of("CLIENT_READ", "CLIENT_WRITE"));

        return Jwts.builder()
            .setClaims(claims)
            .setSubject(userDetails.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1h
            .signWith(getSigningKey(), SignatureAlgorithm.HS256)
            .compact();
    }

}
