package com.easyexcel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easyexcel.mapper.StudentMapper;
import com.easyexcel.pojo.Student;
import com.easyexcel.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Override
    public int updateBatch(List<Student> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<Student> list) {
        return baseMapper.batchInsert(list);
    }
}
