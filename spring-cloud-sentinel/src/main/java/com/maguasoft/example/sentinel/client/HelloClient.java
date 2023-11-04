package com.maguasoft.example.sentinel.client;

import com.maguasoft.example.sentinel.DefaultOpenfeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "spring-cloud-openfeign", configuration = DefaultOpenfeignConfig.class)
public interface HelloClient {

    @GetMapping("/hello")
    String sayHello(@RequestParam("name") String name);
}
