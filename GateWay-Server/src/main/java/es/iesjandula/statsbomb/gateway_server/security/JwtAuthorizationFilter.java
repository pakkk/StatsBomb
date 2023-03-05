package es.iesjandula.statsbomb.gateway_server.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 04/03/2023
 */
@Component
public class JwtAuthorizationFilter implements GatewayFilter
{

    @Value("${security.jwt.secret-key}")
    private String jwtSecret;


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain)
    {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        String authorizationHeader = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);



        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String jwtToken = authorizationHeader.substring(7);
            try {
                Jwts.parserBuilder().setSigningKey(jwtSecret.getBytes()).build().parseClaimsJws(jwtToken);
            } catch (JwtException e) {
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return Mono.empty();
            }
        } else {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return Mono.empty();
        }

        return chain.filter(exchange);
    }
}

