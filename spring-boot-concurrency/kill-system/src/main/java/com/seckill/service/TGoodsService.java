package com.seckill.service;

import java.util.List;
import com.seckill.pojo.TGoods;
import com.baomidou.mybatisplus.extension.service.IService;
public interface TGoodsService extends IService<TGoods>{


    int updateBatch(List<TGoods> list);

    int batchInsert(List<TGoods> list);

}
