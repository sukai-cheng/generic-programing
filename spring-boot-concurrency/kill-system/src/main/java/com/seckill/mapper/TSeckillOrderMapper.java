package com.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seckill.pojo.TSeckillOrder;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSeckillOrderMapper extends BaseMapper<TSeckillOrder> {
    int updateBatch(List<TSeckillOrder> list);

    int batchInsert(@Param("list") List<TSeckillOrder> list);
}