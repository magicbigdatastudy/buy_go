package net.noyark.seckill;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)
public class RabbitMQReceiver {

    @RabbitListener(queues = "seckillQueue")
    public void spendMsg(String msg) {//接收到的信息
        //异步监听到获取的消息msg可以是id
        //打印
        System.out.println(111);
        System.out.println(msg);
    }
}
