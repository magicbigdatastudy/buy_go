package net.noyark.seckill.mapper;

import net.noyark.seckill.entity.Seckill;

import java.util.List;

public interface SeckillMapper {

    Seckill selectByPrimaryKey(Long id);

    List<Seckill> selectAll();

}
