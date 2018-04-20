package cn.xiuyu.service.redis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.xiuyu.service.ServiceAppliactionTest;
import redis.clients.jedis.JedisCluster;

public class RedisTest extends ServiceAppliactionTest {

    @Autowired
    private JedisCluster jedisCluster;

    @Test
    public void test1() {
        jedisCluster.set("test", "t1");
        System.out.println("save redis success");
    }
}
