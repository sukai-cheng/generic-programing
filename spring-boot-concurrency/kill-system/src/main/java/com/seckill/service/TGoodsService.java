package com.seckill.service;

import java.util.List;
import com.seckill.pojo.TGoods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.seckill.vo.GoodsVo;
import org.apache.ibatis.annotations.Param;

public interface TGoodsService extends IService<TGoods>{
    int updateBatch(List<TGoods> list);

    int batchInsert(List<TGoods> list);

    List<GoodsVo> findGoodsVo();

    GoodsVo findGoodsVoByGoodsId(@Param("goodsId") Long goodsId);
}
