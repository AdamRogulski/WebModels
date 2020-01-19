package com.example.WebModels.security;

import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class JwtTokenUtil implements Serializable {

    public String generateToken(Authentication authentication){
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(myUserDetails.getUsername())
                .signWith(SignatureAlgorithm.HS512,"SecretKey")
                .compact();
    }

    public boolean validateJwtToken(String authToken) {

        try {
            Jwts.parser().setSigningKey("SecretKey").parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            System.err.println("Invalid JWT signature" + e);
        } catch (MalformedJwtException e) {
            System.err.println("Invalid JWT token"+ e);
        }  catch (UnsupportedJwtException e) {
            System.err.println("Unsupported JWT token"+ e);
        } catch (IllegalArgumentException e) {
            System.err.println("JWT claims string is empty"+ e);
        }
        return false;
    }

    public String getUsernameFromToken(String token){

        return Jwts.parser()
                .setSigningKey("SecretKet")
                .parseClaimsJws(token)
                .getBody().getSubject();
    }
}
