package com.easyexcel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easyexcel.pojo.ActResultLogDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActResultLogMapper extends BaseMapper<ActResultLogDO> {
    int updateBatch(List<ActResultLogDO> list);

    int batchInsert(@Param("list") List<ActResultLogDO> list);

    void importToDb(List<ActResultLogDO> actResultLogList);
}