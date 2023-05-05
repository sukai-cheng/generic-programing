package com.easyexcel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easyexcel.pojo.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper extends BaseMapper<Course> {
    int updateBatch(List<Course> list);

    int batchInsert(@Param("list") List<Course> list);
}