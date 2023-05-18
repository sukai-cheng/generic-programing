package com.easyexcel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.easyexcel.pojo.Course;

import java.util.List;
public interface CourseService extends IService<Course>{


    int updateBatch(List<Course> list);

    int batchInsert(List<Course> list);

}
