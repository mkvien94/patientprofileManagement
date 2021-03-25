package com.zuul.gateway;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.spi.json.JacksonJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import com.zuul.gateway.config.AppAuthenticationProvider;
import com.zuul.gateway.config.AppRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collections;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableFeignClients(basePackages = "com.zuul.gateway")
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public AppAuthenticationProvider customAuthenticationProvider() {
        return new AppAuthenticationProvider();
    }

    @Bean
    public com.jayway.jsonpath.Configuration configuration(@Autowired ObjectMapper objectMapper) {
        return com.jayway.jsonpath.Configuration.builder()
                .jsonProvider(new JacksonJsonProvider(objectMapper))
                .mappingProvider(new JacksonMappingProvider(objectMapper))
                .options(com.jayway.jsonpath.Option.DEFAULT_PATH_LEAF_TO_NULL)
                .options(com.jayway.jsonpath.Option.SUPPRESS_EXCEPTIONS).build();
    }

    @Bean
    public AppRequestInterceptor customRequestInterceptor() {
        return new AppRequestInterceptor();
    }
}
