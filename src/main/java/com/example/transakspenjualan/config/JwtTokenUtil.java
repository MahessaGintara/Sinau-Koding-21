package com.example.transakspenjualan.config;

import com.example.transakspenjualan.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {
    private static final long JWT_TOKEN_VALIDITY=  5 * 60 * 60 ;

    @Value("${jwt.secret}")
    private String secret;

    public String doGenerateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, secret).compact();
    }

    public String getUsernameFromToken(String token){
        final Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

        return  claims.getSubject();
    }

    public Boolean validateToken(String token, User user){
        String username = getUsernameFromToken(token);
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        boolean isExpired = claims.getExpiration().before(new Date());

        return (username.equals(user.getUsername()) && !isExpired);
    }
}
