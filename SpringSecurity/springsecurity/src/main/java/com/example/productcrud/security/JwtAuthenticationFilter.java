package com.example.productcrud.security;
import com.example.productcrud.model.User;
import com.example.productcrud.repository.RevokedTokenRepository;
import com.example.productcrud.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RevokedTokenRepository revokedTokenRepository;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
		throws ServletException, IOException {
		String token = request.getHeader("Authorization");
		if (token != null && token.startsWith("Bearer ")) {
			token = token.substring(7);
			if (jwtUtil.isTokenExpired(token)) {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.getWriter().write("Invalid or expired token.");
				return;
			}
			if (revokedTokenRepository.findById(token).isPresent()) {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.getWriter().write("Token has been revoked.");
				return;
			}
			String username = jwtUtil.getUsernameFromToken(token);
			String role = jwtUtil.getRoleFromToken(token);
			Optional<User> user = userRepository.findByUsername(username);
			if (user.isPresent()) {
				List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(role));
				SecurityContextHolder.getContext()
						.setAuthentication(new UsernamePasswordAuthenticationToken(username, null, authorities));
				System.out.println("Authorities: " + authorities);
			}
		}
		chain.doFilter(request, response);
	}
}
