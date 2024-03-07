package com.jwt.utils;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.jwt.exception.AccessDeniedException;
import com.jwt.model.User;

import io.jsonwebtoken.Claims;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {

	private static String securityKey="java";
	
	public static String createToken(User user) {
		
		long currentTime=System.currentTimeMillis();
		long expiration=300000+currentTime;
		
		Date issuedAt=new Date(currentTime);
		Date expiredAt=new Date(expiration);
		    
	       Claims claims=Jwts.claims().setIssuer(user.getId().toString())
	       				.setIssuedAt(issuedAt)
	       				.setExpiration(expiredAt);
	       
	      
	        
	        claims.put("name", user.getName());
	        claims.put("phone", user.getPhoneNumber());
	        
	        String token=Jwts.builder()
	        				 .setClaims(claims)
	        				 .signWith(SignatureAlgorithm.HS256, securityKey).compact();
	        				 
	        
	     
	        
	        
		return token;
	}
	
	public void verify(String token) throws Exception{ 
		try {
		Jwts.parser().setSigningKey(securityKey).parseClaimsJws(token);
		}
		catch (Exception e) {
			throw new AccessDeniedException("Access denied");
		}
	}
}
