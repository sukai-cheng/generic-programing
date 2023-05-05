package com.easyexcel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easyexcel.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {
    int updateBatch(List<Student> list);

    int batchInsert(@Param("list") List<Student> list);
}