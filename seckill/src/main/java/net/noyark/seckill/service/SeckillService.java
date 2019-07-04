package net.noyark.seckill.service;

import net.noyark.seckill.entity.Seckill;
import net.noyark.seckill.mapper.SeckillMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeckillService {

    @Autowired
    private SeckillMapper mapper;

    @Autowired
    private AmqpTemplate template;

    public Seckill querySeckill(Long id){
        return mapper.selectByPrimaryKey(id);
    }

    public List<Seckill> queryList(){
        return mapper.selectAll();
    }

    public void startKill(Long id,String phone){
        //写入rabbitmq的消息内容，封装一下
        template.convertAndSend("setQueue",id+"/"+phone);
        //id可以在消费端获取商品信息，一旦秒杀成功，减少库存
        //userPhone作为用户信息，成功则入库，失败则返回
        // 目前缺点
        // 没有处理手机user信息的逻辑 -> 拦截器拦截，只允许一个人操作
        // 多线程安全 -> 加锁
        // 配合redis
        // 分布式事务锁+watch，当集群发现有客户端在操作一个key值时，利用事物锁，和
        //watch，完成只有一个用户来操作 incr decr key number
    }


}
