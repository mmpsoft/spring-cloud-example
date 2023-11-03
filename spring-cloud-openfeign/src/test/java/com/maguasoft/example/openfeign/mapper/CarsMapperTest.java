package com.maguasoft.example.openfeign.mapper;

import com.maguasoft.example.openfeign.domain.Cars;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class CarsMapperTest {

    @Autowired
    private CarsMapper carsMapper;

    @Test
    public void testGet() {
        Cars cars = carsMapper.selectById(1);
        log.info("{}", cars);
    }
}
