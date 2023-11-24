package com.foronly.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author li_cang_long
 * @since 2023/11/13 18:26
 */
@Component
public class RedisCache {

	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;

	/*
	 * 对RedisTemplate的方法进行封装
	 *
	 * */

}
