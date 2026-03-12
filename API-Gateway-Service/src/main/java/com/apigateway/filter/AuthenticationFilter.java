package com.apigateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    @Autowired
    private RouteValidator validator;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {

        return (exchange, chain) -> {

            System.out.println("Incoming Path: " + exchange.getRequest().getURI().getPath());
            if (validator.isSecured.test(exchange.getRequest())) {

                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new RuntimeException("Missing Authorization Header");
                }

                String authHeader =
                        exchange.getRequest().getHeaders()
                                .getFirst(HttpHeaders.AUTHORIZATION);

                String token = null;

                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    token = authHeader.substring(7);
                }

                try {

                    webClientBuilder.build()
                            .get()
                            .uri("http://AUTH-SERVICE/validateToken?token=" + token)
                            .retrieve()
                            .bodyToMono(String.class)
                            .block();

                } catch (Exception e) {
                    throw new RuntimeException("Unauthorized access");
                }
            }

            return chain.filter(exchange);
        };
    }

    public static class Config {
    }
}