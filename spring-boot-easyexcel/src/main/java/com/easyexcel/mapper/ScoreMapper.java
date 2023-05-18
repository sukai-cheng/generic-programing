package com.easyexcel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easyexcel.pojo.Score;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScoreMapper extends BaseMapper<Score> {
    int batchInsert(@Param("list") List<Score> list);
}