package com.maguasoft.example.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * 自定义路由过滤器，类名以 GatewayFilterFactory 结尾
 */
@Slf4j
@Component
public class ExampleGatewayFilterFactory extends AbstractGatewayFilterFactory<Object> {

    @Override
    public GatewayFilter apply(Object config) {
        // 如果需要实现过滤器的排序，可实现 OrderedGatewayFilter 过滤器，实现getOrder方法即可，order越小的过滤器越早执行
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

                // 表示终结filter，不在执行后面的filter琏
                // exchange.getResponse().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
                // return exchange.getResponse().setComplete();
                return chain.filter(exchange);
            }
        };
    }
}
