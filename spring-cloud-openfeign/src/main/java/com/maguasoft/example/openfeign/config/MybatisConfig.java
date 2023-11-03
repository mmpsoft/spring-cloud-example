package com.maguasoft.example.openfeign.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.maguasoft.example.openfeign.mapper")
public class MybatisConfig {
}
