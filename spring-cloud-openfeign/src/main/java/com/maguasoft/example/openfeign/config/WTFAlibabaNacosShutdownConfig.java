package com.maguasoft.example.openfeign.config;

import com.alibaba.cloud.nacos.discovery.NacosWatch;
import com.alibaba.cloud.nacos.registry.NacosAutoServiceRegistration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 解决Nacos，在 Undertow 容器停机时报 ‘java.lang.IllegalStateException: UT015023: This Context has been already destroyed' 的错误。
 * F**k you, Nacos
 */
@Slf4j
@Configuration
public class WTFAlibabaNacosShutdownConfig implements InitializingBean {

    @Autowired
    private NacosWatch nacosWatch;

    @Autowired
    private NacosAutoServiceRegistration nacosAutoServiceRegistration;

    @Override
    public void afterPropertiesSet() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (nacosWatch != null) {
                log.info("Shutting down NacosWatch");
                try {
                    nacosWatch.stop();
                } catch (Exception e) {
                    log.info("Shutting down NacosWatch fail!", e);
                }
            }
            if (nacosAutoServiceRegistration != null) {
                log.info("Shutting down NacosAutoServiceRegistration");
                try {
                    nacosAutoServiceRegistration.stop();
                } catch (Exception e) {
                    log.info("Shutting down NacosAutoServiceRegistration fail!", e);
                }
            }
        }));
    }
}
