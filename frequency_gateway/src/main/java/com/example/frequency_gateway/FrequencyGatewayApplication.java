package com.example.frequency_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class FrequencyGatewayApplication {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder )
//    public static void main(String[] args) {
//        SpringApplication.run(FrequencyGatewayApplication.class, args);
//    }
}
