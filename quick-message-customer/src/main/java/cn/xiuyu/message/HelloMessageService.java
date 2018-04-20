package cn.xiuyu.message;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = "queue")
public class HelloMessageService {

    @RabbitHandler
    public void process(String message) {
        System.out.println("Receiver : " + message);
    }

}
