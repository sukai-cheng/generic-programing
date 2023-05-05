package com.easyexcel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.easyexcel.pojo.Student;

import java.util.List;
public interface StudentService extends IService<Student>{


    int updateBatch(List<Student> list);

    int batchInsert(List<Student> list);

}
