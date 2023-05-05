package com.easyexcel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.easyexcel.pojo.Score;

import java.util.List;
public interface ScoreService extends IService<Score>{


    int batchInsert(List<Score> list);

}
