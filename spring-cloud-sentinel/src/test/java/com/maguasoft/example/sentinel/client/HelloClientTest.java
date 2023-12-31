package com.maguasoft.example.sentinel.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("local")
public class HelloClientTest {

    @Autowired
    private HelloClient helloClient;

    @Test
    public void testSayHello() {
        helloClient.sayHello("zhangsan");
    }
}
