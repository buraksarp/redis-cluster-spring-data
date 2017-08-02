package com.sarp.redis.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by sarp on 5/21/17.
 */

@Service
public class RedisService {

    private final RedisTemplate<String, String> redisTemplate;

    public RedisService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    //add value with ttl
    public void addValue(String key, String value) {
        this.redisTemplate.opsForValue().set(key, value, 360, TimeUnit.SECONDS);
    }

    public String getValue(String key) {
        return this.redisTemplate.opsForValue().get(key);
    }

    public int getKeysCount() {
        return this.redisTemplate.keys("*").size();
    }
}
