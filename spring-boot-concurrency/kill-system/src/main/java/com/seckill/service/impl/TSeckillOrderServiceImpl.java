package com.seckill.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.seckill.mapper.TSeckillOrderMapper;
import com.seckill.pojo.TSeckillOrder;
import com.seckill.service.TSeckillOrderService;
@Service
public class TSeckillOrderServiceImpl extends ServiceImpl<TSeckillOrderMapper, TSeckillOrder> implements TSeckillOrderService{

    @Override
    public int updateBatch(List<TSeckillOrder> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<TSeckillOrder> list) {
        return baseMapper.batchInsert(list);
    }
}
