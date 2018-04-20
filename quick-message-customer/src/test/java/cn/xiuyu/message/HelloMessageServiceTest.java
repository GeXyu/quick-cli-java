package cn.xiuyu.message;

import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import cn.xiuyu.MessageApplicationTest;

public class HelloMessageServiceTest extends MessageApplicationTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void send() {
        rabbitTemplate.convertAndSend("queue", "test-Message");
    }

}
