package com.qalamcode.gateway_proxy.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;

@Configuration
public class GatewayConfig {

    @Bean 
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        // Pour les API externes
        return builder.routes()
            .route("muslimsalatapi",
                r -> r.path("/muslimsalatapi/**")
                        .filters(f -> f
                            //// Supprime le préfixe /muslimsalat
                            .rewritePath("/muslimsalatapi/(?<segment>.*)", "/${segment}")
                            //// Ajoute un header personnalisé
                            //.addRequestHeader("X-Gateway-Source", "GatewayProxy")
                            //// Ajoute un paramètre de requête
                            //.addRequestParameter("apiKey", "YOUR_API_KEY_HERE")
                            //// Logique d'ajout de réponse
                            //.addResponseHeader("X-Powered-By", "QalamCode Gateway")
                            .circuitBreaker(config -> config
                              .setName("muslimsalatapiCB")
                              .setFallbackUri("forward:/fallback/muslimsalatapi"))
                        )
                        .uri("https://muslimsalat.com"))
            .route("thescountries", 
                r -> r.path("/thescountries/**")
                    .filters(f -> f
                            //// Supprime le préfixe /muslimsalat
                            .rewritePath("/thescountries/(?<segment>.*)", "/${segment}")
                            //// Ajoute un header personnalisé
                            .addRequestHeader("x-rapidapi-host", "ajayakv-rest-countries-v1.p.rapidapi.com")
                            //// Ajoute un paramètre de requête
                            //.addRequestParameter("apiKey", "YOUR_API_KEY_HERE")
                            //// Logique d'ajout de réponse
                            //.addResponseHeader("X-Powered-By", "QalamCode Gateway")
                            .circuitBreaker(config -> config
                              .setName("thescountriesCB")
                              .setFallbackUri("forward:/fallback/thescountries"))
                        )
                    .uri("https://ajayakv-rest-countries-v1.p.rapidapi.com"))
            .build();
    }

    @Bean
    public DiscoveryClientRouteDefinitionLocator discoveryClientRouteDefinitionLocator(
            ReactiveDiscoveryClient discoveryClient,
            DiscoveryLocatorProperties properties) {
        return new DiscoveryClientRouteDefinitionLocator(discoveryClient, properties);
    }
}