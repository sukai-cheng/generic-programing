package com.easyexcel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easyexcel.mapper.CourseMapper;
import com.easyexcel.pojo.Course;
import com.easyexcel.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Override
    public int updateBatch(List<Course> list) {
        return this.updateBatch(list);
    }
    @Override
    public int batchInsert(List<Course> list) {
        return baseMapper.batchInsert(list);
    }
}
