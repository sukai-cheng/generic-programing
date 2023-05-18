package com.easyexcel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easyexcel.mapper.ScoreMapper;
import com.easyexcel.pojo.Score;
import com.easyexcel.service.ScoreService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements ScoreService {

    @Override
    public int batchInsert(List<Score> list) {
        return baseMapper.batchInsert(list);
    }
}
