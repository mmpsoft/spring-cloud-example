package com.maguasoft.example.openfeign.mapper;

import com.maguasoft.example.openfeign.domain.Account;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTemplateTest {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private RedisTemplate<String, Account> accountRedisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final Integer CACHE_EXPIRE_30S = 30;
    private static final Integer CACHE_EXPIRE_30M = 30 * 60;
    private static final Integer CACHE_EXPIRE_8H = 8 * 60 * 60;
    private static final Integer CACHE_EXPIRE_24H = 24 * 60 * 60;

    @Test
    public void testCachePut() {
//        stringRedisTemplate.opsForValue().set("test", "teststtttt");
//        redisTemplate.opsForValue().set("string", "1");
//        redisTemplate.opsForList().leftPush("list", 1);
//        redisTemplate.opsForSet().add("set", 1);

//        RedisHelper<String> redisHelper = RedisHelper.of(redisTemplate);
//        redisHelper.set("spring:cloud:openfeign", "111111");
//        log.info(redisHelper.get("spring:cloud:openfeign"));
//
//        log.info(redisHelper.getAndSet("spring:cloud:openfeign", "222222"));

        accountRedisTemplate.opsForValue().set("spring:cloud:openfeign", new Account(1, "zhangsan"));
        Account account = accountRedisTemplate.opsForValue().get("spring:cloud:openfeign");
        log.info("{}", account);
    }

    @Test
    public void testCacheGet() {
        log.info("{}", stringRedisTemplate.opsForValue().get("test"));
        log.info("{}", stringRedisTemplate.opsForValue().get("config3"));
        log.info("{}", redisTemplate.opsForValue().get("config3"));
        log.info("{}", redisTemplate.opsForList().leftPop("list"));
        log.info("{}", redisTemplate.opsForSet().pop("set"));
        log.info("{}", redisTemplate.opsForHash().get("config2", "11"));
    }


    public static final class RedisHelper<V> {

        // String CACHE_KEY_PREFIX = "project:module:business:uniqueId";
        // String CACHE_KEY_PREFIX = "spring-cloud-example:spring-cloud-openfeign:product:1020002";

        private final RedisTemplate<Object, Object> redisTemplate;

        private RedisHelper(RedisTemplate<Object, Object> redisTemplate) {
            this.redisTemplate = redisTemplate;
        }

        public static <VV> RedisHelper<VV> of(RedisTemplate<Object, Object> redisTemplate) {
            return new RedisHelper<>(redisTemplate);
        }

        public static RedisHelper<String> newString(RedisTemplate<Object, Object> redisTemplate) {
            return new RedisHelper<>(redisTemplate);
        }

        public static <VV> RedisHelper<Collection<VV>> newArray(RedisTemplate<Object, Object> redisTemplate) {
            return new RedisHelper<>(redisTemplate);
        }

        public static <VV> RedisHelper<VV> newHash(RedisTemplate<Object, Object> redisTemplate) {
            return new RedisHelper<>(redisTemplate);
        }

        public V getAndSet(String key, V value) {
            Object andSet = redisTemplate.opsForValue().getAndSet(key, value);
            return (V) andSet;
        }

        public void set(String key, V value) {
            redisTemplate.opsForValue().set(key, value);
        }

        public V get(String key) {
            return (V) redisTemplate.opsForValue().get(key);
        }
    }
}
