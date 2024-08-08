package com.aishwarya.cloudgateway.filter;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AuthenticationFilter extends AbstractGatewayFilterFactory<Object> {

    private final RouteValidator validator;
    private final WebClient.Builder webClientBuilder;

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            if (validator.isSecured.test(exchange.getRequest())) {
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    return Mono.error(new RuntimeException("Missing authorization header"));
                }

                String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    authHeader = authHeader.substring(7);

                    return webClientBuilder.build()
                            .get()
                            .uri("http://AUTH-SERVICE/auth/validate?token=" + authHeader)
                            .retrieve()
                            .bodyToMono(String.class)
                            .flatMap(authResponse -> {
                                if ("Token is valid".equals(authResponse)) {
                                    return chain.filter(exchange);
                                } else {
                                    return Mono.error(new RuntimeException("Unauthorized access to application"));
                                }
                            })
                            .onErrorResume(exception -> {
                                exception.printStackTrace();
                                return Mono.error(new RuntimeException("Error validating token"));
                            });
                } else {
                    return Mono.error(new RuntimeException("Invalid authorization header"));
                }
            }
            return chain.filter(exchange);
        };
    }
}
