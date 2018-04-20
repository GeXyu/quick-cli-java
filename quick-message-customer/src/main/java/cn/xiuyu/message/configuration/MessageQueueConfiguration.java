package cn.xiuyu.message.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageQueueConfiguration {

	@Bean
	public Queue queue() {
		return new Queue("queue");
	}
}
