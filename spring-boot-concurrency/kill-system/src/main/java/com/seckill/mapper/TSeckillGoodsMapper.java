package com.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seckill.pojo.TSeckillGoods;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSeckillGoodsMapper extends BaseMapper<TSeckillGoods> {
    int updateBatch(List<TSeckillGoods> list);

    int batchInsert(@Param("list") List<TSeckillGoods> list);
}