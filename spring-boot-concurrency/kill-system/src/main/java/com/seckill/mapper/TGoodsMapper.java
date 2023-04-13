package com.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seckill.pojo.TGoods;
import java.util.List;

import com.seckill.vo.GoodsVo;
import org.apache.ibatis.annotations.Param;

public interface TGoodsMapper extends BaseMapper<TGoods> {
    int updateBatch(List<TGoods> list);

    int batchInsert(@Param("list") List<TGoods> list);

    List<GoodsVo> findGoodsVo();
}