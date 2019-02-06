package com.cts.articlesearch.jwt.security;

import org.springframework.stereotype.Component;

import com.cts.articlesearch.bean.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {


    public JwtGenerator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String generate(User user) {


        Claims claims = Jwts.claims()
                .setSubject(user.getName());
        claims.put("userId", String.valueOf(user.getId()));
        claims.put("role", user.getRole().getRole());


        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "articlesearch")
                .compact();
    }
}
