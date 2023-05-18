package com.easyexcel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easyexcel.pojo.ActResultLogDO;
import com.easyexcel.pojo.JobList;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author chengsukai
 */
public interface JobListMapper extends BaseMapper<JobList> {
    int updateBatch(List<JobList> list);

    int batchInsert(@Param("list") List<JobList> list);

    void importToDb(List<JobList> jobListList);

}