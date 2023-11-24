package com.foronly.demo.redis;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;

@SpringBootTest
class RedisDemoApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	void contextLoads() {
		Set keys = redisTemplate.keys("*");
		System.out.println(keys);
		keys.forEach(item -> {
			Object o = redisTemplate.opsForValue().get(item);
			System.out.println(o.toString());
		});
	}

	@Test
	void testPut() {
		redisTemplate.opsForValue().set("TEST", "THIS IS A TEST");
	}

}
