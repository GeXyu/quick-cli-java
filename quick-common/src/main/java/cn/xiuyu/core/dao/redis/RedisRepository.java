package cn.xiuyu.core.dao.redis;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

/**
 * redis
 * 
 * @author ge
 *
 */
@Component
public class RedisRepository {

	@Autowired
    private StringRedisTemplate redisTemplate;

	public <T> void save(String key, List<T> list) {
		redisTemplate.opsForList().set(key, 1, JSON.toJSONString(list));
	}

	public <K, V> void save(String key, HashMap<K, V> map) {
		redisTemplate.opsForHash().put(key, 1, JSON.toJSONString(map));
	}

	public <T> void save(String key, T t) {
		redisTemplate.opsForValue().set(key, JSON.toJSONString(t));
	}

	/*
	 * public <T> T getMap(String key, Object opt, Class<T> clazz) {
	 * JSON.parseObject(redisTemplate.opsForHash().get(key, opt), clazz); }
	 */
}
