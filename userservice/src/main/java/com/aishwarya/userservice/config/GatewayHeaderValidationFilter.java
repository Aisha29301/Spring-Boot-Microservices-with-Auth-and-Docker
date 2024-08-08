package com.aishwarya.userservice.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import java.io.IOException;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class GatewayHeaderValidationFilter extends OncePerRequestFilter {

    private static final String GATEWAY_SECRET_HEADER = "X-Gateway-Secret";
    private static final String GATEWAY_SECRET = "test";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String headerValue = request.getHeader(GATEWAY_SECRET_HEADER);
        if (GATEWAY_SECRET.equals(headerValue)) {
            filterChain.doFilter(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Unauthorized access");
        }
    }
}
