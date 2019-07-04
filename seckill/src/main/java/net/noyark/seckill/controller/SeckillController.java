package net.noyark.seckill.controller;



import net.noyark.seckill.entity.Seckill;
import net.noyark.seckill.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class SeckillController {

    @Autowired
    private SeckillService service;

    @RequestMapping("/seckill/all")
    public String goIndex(Model model){
        List<Seckill> seckillList = service.queryList();
        model.addAttribute("list",seckillList);
        System.out.println(seckillList);
        return "/list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Seckill> getAll(Model model){

        return (List<Seckill>) model.asMap().get("list");
    }

    /**
     * 进入秒杀页面
     * @param id
     * @param model
     * @return
     */

    @RequestMapping("/seckill/{id}/detail")
    @ResponseBody
    public Seckill detail(@PathVariable("id")Long id, Model model){
        Seckill seckill = service.querySeckill(id);
        model.addAttribute("seckill",seckill);
        System.out.println(seckill);
        return seckill;
    }
    /**
     * 返回当前时间
     */
    @RequestMapping("seckill/time/now")
    @ResponseBody
    public Date now(){
        return new Date();
    }
    /**
     * 接收请求，获取user信息，模拟的使用for循环
     * 代表多用户请求
     */
    //生产者代码
    //controller接收秒杀请求，获取user信息，数据写入队列，后续由消费者
    //完成
    //为了达到多用户秒杀，使用dfor循环模拟生成多个电话对应的用户的秒杀要求
    //接口文件
    //请求 get
    //请求url /seckill/{seckillId}
    //返回String "success" @ResponseBody
    @RequestMapping("seckill/{id}")
    @ResponseBody
    public String startKill(@PathVariable Long id){
        for(int i = 100;i<190;i++){
            service.startKill(id,"133098246");
        }
        return "success";
    }
    //消费者代码
    //获取消息，id，userPhone，截取后，利用id来更新秒杀
    //商品的库存(-1)执行成功，秒杀成功，userPhone写入成功
    //的记录表格success_killed（展示成功的信息，这个表格获取userPhone)

}
