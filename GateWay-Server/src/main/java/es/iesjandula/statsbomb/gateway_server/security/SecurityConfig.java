package es.iesjandula.statsbomb.gateway_server.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 04/03/2023
 */
@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthorizationFilter jwtAuthorizationFilter;

    private RouteLocatorBuilder routeLocatorBuilder;

    @Autowired
    public SecurityConfig(RouteLocatorBuilder routeLocatorBuilder) {
        this.routeLocatorBuilder = routeLocatorBuilder;
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder, JwtAuthorizationFilter jwtAuthorizationFilter)
    {
         return routeLocatorBuilder.routes()
            .route("competitions", r -> r.path("/competitions/**")
            .filters(f -> f.filter(jwtAuthorizationFilter))
            .uri("lb://competitions"))

            .route("matches", r -> r.path("/matches/**")
            .filters(f -> f.filter(jwtAuthorizationFilter))
            .uri("lb://matches"))

            .route("events", r -> r.path("/events/**")
            .filters(f -> f.filter(jwtAuthorizationFilter))
            .uri("lb://events"))

            .route("lineups", r -> r.path("/lineups/**")
            .filters(f -> f.filter(jwtAuthorizationFilter))
            .uri("lb://lineups"))

            .build();
    }

}
