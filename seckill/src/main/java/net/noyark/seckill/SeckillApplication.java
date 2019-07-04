package net.noyark.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableRabbit
@MapperScan("net.noyark.seckill.mapper")
public class SeckillApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillApplication.class, args);
    }

    /**
     * 声明交换机
     * @return
     */
    @Bean
    public DirectExchange defaultExchange(){
       return new DirectExchange("rabbitmq-seckill");
    }
    /**
     * 声明队列
     */
    @Bean
    public Queue queue(){
        return new Queue("seckillQueue");
    }

    /**
     * 绑定
     * @return
     */
    @Bean
    public Binding bind(){
        return BindingBuilder.bind(queue()).to(defaultExchange()).with("setQueue");
    }



}
