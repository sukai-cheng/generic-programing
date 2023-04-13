package com.seckill.service;

import java.util.List;
import com.seckill.pojo.TOrder;
import com.baomidou.mybatisplus.extension.service.IService;
public interface TOrderService extends IService<TOrder>{


    int updateBatch(List<TOrder> list);

    int batchInsert(List<TOrder> list);

}
