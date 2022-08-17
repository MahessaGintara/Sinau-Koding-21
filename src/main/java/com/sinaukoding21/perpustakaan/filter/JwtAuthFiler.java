package com.sinaukoding21.perpustakaan.filter;

import com.sinaukoding21.perpustakaan.config.JwtTokenUtil;
import com.sinaukoding21.perpustakaan.model.User;
import com.sinaukoding21.perpustakaan.repository.UserRepository;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JwtAuthFiler extends OncePerRequestFilter {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        String username = null;
        String token = null;

        if(header != null && header.startsWith("Bearer ")){
            token = header.replace("Bearer ", "");

            try {
                username = jwtTokenUtil.getUsernameFromToken(token);
            }catch (IllegalArgumentException e){
                logger.error("Error mendapatkan username dari token");
            }catch (ExpiredJwtException e){
                logger.error("Token expired");
            }catch (SignatureException e){
                logger.error("username atau password tidak sesuai");
            }
        }else{
            logger.warn("header tidak di sett / tidak dapat menemukan token");
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            User user = userRepository.findByUsername(username);

            if (jwtTokenUtil.validateToken(token, user)){
                //UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());

                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getName());

                List<SimpleGrantedAuthority> authorities = new ArrayList<>();
                authorities.add(authority);

                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, authorities);

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
