package com.easyexcel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easyexcel.po.UserPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUserMapper extends BaseMapper<UserPO> {
    int updateBatch(List<UserPO> list);

    int batchInsert(@Param("list") List<UserPO> list);
}