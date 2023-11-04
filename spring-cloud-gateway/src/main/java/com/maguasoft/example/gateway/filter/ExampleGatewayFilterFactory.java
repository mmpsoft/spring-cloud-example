package com.maguasoft.example.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Map;

@Slf4j
@Component
public class ExampleGatewayFilterFactory extends AbstractGatewayFilterFactory<ExampleGatewayFilterConfig> {

    @Override
    public GatewayFilter apply(ExampleGatewayFilterConfig config) {
        return new GatewayFilter() {
            /**
             * @param exchange 整个请求的上下文，包含request, response, attr等信息
             * @param chain    filter的执行琏，调用 chain.filter(exchange)方法，执行下一个filter
             * @return
             */
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                ServerHttpRequest request = exchange.getRequest();
                ServerHttpResponse response = exchange.getResponse();
                Map<String, Object> attributes = exchange.getAttributes();

                log.info("ServerHttpRequest: {}", request);
                log.info("ServerHttpResponse: {}", response);
                log.info("Attributes: {}", attributes);

                return chain.filter(exchange);
            }
        };
    }
}
