package com.maguasoft.example.openfeign.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String sayHello(String name, @RequestHeader("X-Request") String header) {
        log.info("name {}, header {}", name, header);
        return "Hello OpenFeign";
    }
}
