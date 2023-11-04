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

import java.util.List;
import java.util.Map;

/**
 * 自定义可选参数路由过滤器，类名以 GatewayFilterFactory 结尾
 */
@Slf4j
@Component
public class ExampleArgumentGatewayFilterFactory extends AbstractGatewayFilterFactory<ExampleGatewayFilterConfig> {

    /**
     * 返回有关参数数顺序。返回值：提示列表
     *
     * @return List<String>
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return List.of("age", "name", "address");
    }

    /**
     * 参数对象的class
     *
     * @return <ExampleGatewayFilterConfig>
     */
    @Override
    public Class<ExampleGatewayFilterConfig> getConfigClass() {
        return ExampleGatewayFilterConfig.class;
    }

    @Override
    public GatewayFilter apply(ExampleGatewayFilterConfig config) {
        return new GatewayFilter() {
            /**
             * @param exchange 整个请求的上下文，包含request, response, attr等信息
             * @param chain    filter的执行琏，调用 chain.filter(exchange)方法，执行下一个filter
             * @return chain.filter(exchange)
             */
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                ServerHttpRequest request = exchange.getRequest();
                ServerHttpResponse response = exchange.getResponse();
                Map<String, Object> attributes = exchange.getAttributes();

                log.info("ServerHttpRequest: {}", request);
                log.info("ServerHttpResponse: {}", response);
                log.info("Attributes: {}", attributes);

                // 自定义参数
                log.info("age: {}", config.getAge());
                log.info("name: {}", config.getName());
                log.info("address: {}", config.getAddress());

                return chain.filter(exchange);
            }
        };
    }
}
