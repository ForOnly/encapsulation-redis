package com.foronly.common.redis.config;

import com.foronly.common.redis.RedisCache;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * <p>
 * redis配置
 * </p>
 *
 * @author li_cang_long
 * @since 2023/11/15 8:46
 */
@EnableCaching
@Configuration(proxyBeanMethods = false)
@AutoConfigureBefore(RedisAutoConfiguration.class)
@Import({RedisCache.class})
public class RedisConfig {
	@Bean
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<Object, Object>        template   = new RedisTemplate<>();
		FastJson2JsonRedisSerializer<Object> serializer = new FastJson2JsonRedisSerializer<>(Object.class);
		// 配置连接工厂
		template.setConnectionFactory(redisConnectionFactory);
		// 设置字符串类型key-value的序列化方式
		template.setKeySerializer(RedisSerializer.string());
		template.setValueSerializer(serializer);
		// 设置hash类型key-value的序列化方式
		template.setHashKeySerializer(RedisSerializer.string());
		template.setHashValueSerializer(serializer);

		template.afterPropertiesSet();
		return template;
	}

}
