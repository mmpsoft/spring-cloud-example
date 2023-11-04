package com.maguasoft.example.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义GlobalFilter，GlobalFilter无需在配置文件配置
 */
@Slf4j
@Component
public class ExampleGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("Execute ExampleGlobalFilter");

        // ...

        return chain.filter(exchange);
    }

    /**
     * 指定当前过滤器的顺序，order越小的过滤器越早执行
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
