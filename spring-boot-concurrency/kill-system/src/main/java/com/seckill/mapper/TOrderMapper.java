package com.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seckill.pojo.TOrder;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOrderMapper extends BaseMapper<TOrder> {
    int updateBatch(List<TOrder> list);

    int batchInsert(@Param("list") List<TOrder> list);
}