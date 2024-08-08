package com.aishwarya.cloudgateway.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    @Bean
    @LoadBalanced  // Enable load balancing
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

}
