package cn.xiuyu.core.dao.redis;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * redis
 * 
 * @author ge
 *
 */
@Component
public class RedisRepository {

    // @Autowired
    // private StringRedisTemplate redisTemplate;

    public <T> void save(String key, List<T> list) {
        /* redisTemplate.opsForList().set(key, 1, JSON.toJSONString(list)); */
    }

    public <K, V> void save(String key, HashMap<K, V> map) {
        /* redisTemplate.opsForHash().put(key, 1, JSON.toJSONString(map)); */
    }

    public <T> void save(String key, T t) {
        /* redisTemplate.opsForValue().set(key, JSON.toJSONString(t)); */
    }

    public Boolean isExistSet(String key, String obj) {
        return false;
        // return redisTemplate.opsForSet().isMember(key, obj);
    }

    public void addSet(String key, String obj) {
        /* redisTemplate.opsForSet().add(key, obj); */
    }

}
