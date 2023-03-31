package com.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seckill.pojo.TUser;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserMapper extends BaseMapper<TUser> {
    int updateBatch(List<TUser> list);

    int batchInsert(@Param("list") List<TUser> list);
}