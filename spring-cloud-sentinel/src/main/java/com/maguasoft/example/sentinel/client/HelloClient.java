package com.maguasoft.example.sentinel.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("spring-cloud-openfeign")
public interface HelloClient {

    @GetMapping("/hello")
    String sayHello(@RequestParam("name") String name);
}
