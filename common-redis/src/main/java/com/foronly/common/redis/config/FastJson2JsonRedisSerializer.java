package com.foronly.common.redis.config;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.filter.Filter;
import com.foronly.common.redis.Constants;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * <p>
 * 使用FastJson2配置redis序列化
 * </p>
 *
 * @author li_cang_long
 * @since 2023/11/23 19:17
 */
public class FastJson2JsonRedisSerializer<T> implements RedisSerializer<T> {
	public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

	static final Filter AUTO_TYPE_FILTER = JSONReader.autoTypeFilter(Constants.JSON_WHITELIST_STR);

	private final Class<T> clazz;

	public FastJson2JsonRedisSerializer(Class<T> clazz) {
		super();
		this.clazz = clazz;
	}

	@Override
	public byte[] serialize(T t) throws SerializationException {
		if (t == null) {
			return new byte[0];
		}
		return JSON.toJSONString(t, JSONWriter.Feature.WriteClassName).getBytes(DEFAULT_CHARSET);
	}

	@Override
	public T deserialize(byte[] bytes) throws SerializationException {
		if (bytes == null || bytes.length == 0) {
			return null;
		}
		String str = new String(bytes, DEFAULT_CHARSET);

		return JSON.parseObject(str, clazz, AUTO_TYPE_FILTER);
	}
}