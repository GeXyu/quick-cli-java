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

    /**
     * 是否存在于set
     * 
     * @param key
     * @param obj
     * @return
     */
    public Boolean isExistSet(String key, String obj) {
        return redisTemplate.opsForSet().isMember(key, obj);
    }

    /**
     * 存放进
     * 
     * @param key
     * @param obj
     */
    public void addSet(String key, String obj) {
        redisTemplate.opsForSet().add(key, obj);
    }

}
