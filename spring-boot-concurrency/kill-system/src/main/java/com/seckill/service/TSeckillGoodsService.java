package com.seckill.service;

import java.util.List;
import com.seckill.pojo.TSeckillGoods;
import com.baomidou.mybatisplus.extension.service.IService;
public interface TSeckillGoodsService extends IService<TSeckillGoods>{


    int updateBatch(List<TSeckillGoods> list);

    int batchInsert(List<TSeckillGoods> list);

}
