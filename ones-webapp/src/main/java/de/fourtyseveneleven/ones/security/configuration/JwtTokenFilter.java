package de.fourtyseveneleven.ones.security.configuration;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.Objects.nonNull;

public class JwtTokenFilter extends OncePerRequestFilter {


	@Override
	protected void doFilterInternal(HttpServletRequest request,
									HttpServletResponse response, FilterChain filterChain)
	        throws ServletException, IOException {

		setJwtTokenAuthenticationIfPresent(request);
		filterChain.doFilter(request, response);
	}

	private void setJwtTokenAuthenticationIfPresent(HttpServletRequest request) {

		final String jwtToken = getRawToken(request);
		if (nonNull(jwtToken)) {
			SecurityContextHolder.getContext()
					.setAuthentication(new JwtTokenAuthentication(jwtToken));
		}
	}

	private String getRawToken(HttpServletRequest request) {

		final String bearerToken = request.getHeader("Authorization");
		if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}

		return null;
	}
}
