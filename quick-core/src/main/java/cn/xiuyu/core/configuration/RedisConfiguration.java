package cn.xiuyu.core.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Title: RedisConfiguration
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年4月15日 下午5:24:52
 * @modified [who date description]
 * @check [who date description]
 */
@Component
@Configuration
public class RedisConfiguration {

    // @Autowired
    // private RedisClusterConfigurationProperties
    // redisClusterConfigurationProperties;
    //
    // @Bean
    // public JedisSentinelPool getJedisSentinelPool() {
    // List<String> nodesList = redisClusterConfigurationProperties.getNodes();
    // Set<String> nodeSet = new HashSet<String>();
    // nodesList.stream().forEach(node -> {
    // String[] hostAndPort = node.split(":");
    // nodeSet.add(String.valueOf(new HostAndPort(hostAndPort[0],
    // Integer.valueOf(hostAndPort[1]))));
    // });
    // return new JedisSentinelPool("mymaster", nodeSet);
    //
    // }

    //
    // @Bean
    // public RedisConnectionFactory connectionFactory() {
    // return new JedisConnectionFactory(
    // new
    // RedisClusterConfiguration(redisClusterConfigurationProperties.getNodes()));
    // }

}
