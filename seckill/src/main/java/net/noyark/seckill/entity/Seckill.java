package net.noyark.seckill.entity;

import java.util.Date;

public class Seckill {

    private long seckillId;
    private String name;
    private int number;
    private long initialPrice;
    private long seckillPrice;
    private String sellPoint;
    private Date createTime;
    private Date startTime;
    private Date endTime;

    public long getSeckillId() {
        return seckillId;
    }
    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public long getInitialPrice() {
        return initialPrice;
    }
    public void setInitialPrice(long initialPrice) {
        this.initialPrice = initialPrice;
    }
    public long getSeckillPrice() {
        return seckillPrice;
    }
    public void setSeckillPrice(long seckillPrice) {
        this.seckillPrice = seckillPrice;
    }
    public String getSellPoint() {
        return sellPoint;
    }
    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getStartTime() {
        return startTime;
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public Date getEndTime() {
        return endTime;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Seckill [seckillId=" + seckillId + ", name=" + name + ", number=" + number + ", initialPrice="
                + initialPrice + ", seckillPrice=" + seckillPrice + ", sellPoint=" + sellPoint + ", createTime="
                + createTime + ", startTime=" + startTime + ", endTime=" + endTime + "]";
    }


}
