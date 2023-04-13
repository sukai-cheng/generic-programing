package com.seckill.service;

import java.util.List;
import com.seckill.pojo.TSeckillOrder;
import com.baomidou.mybatisplus.extension.service.IService;
public interface TSeckillOrderService extends IService<TSeckillOrder>{


    int updateBatch(List<TSeckillOrder> list);

    int batchInsert(List<TSeckillOrder> list);

}
