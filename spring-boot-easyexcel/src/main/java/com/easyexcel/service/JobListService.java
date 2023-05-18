package com.easyexcel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.easyexcel.pojo.ActResultLogDO;
import com.easyexcel.pojo.JobList;

import java.util.List;
import java.util.Map;

/**
 * @author chengsukai
 */
public interface JobListService extends IService<JobList> {


    /**
     * 批量更新
     */
    int updateBatch(List<JobList> list);

    /**
     * 批量插入
     *
     */
    int batchInsert(List<JobList> list);

    /**
     * 通过分页参数查询一百w数据
     */
    List<JobList> findByPage100w(Integer pageNum, Integer pageSize);

    /**
     * 从 Excel 导入数据，批次为 10w，通过 JDBC
     */
    Map<String, Object> import2DBFromExcel10wByJDBC(List<Map<Integer, String>> dataList);

    /**
     * 从 Excel 导入数据，批次为 10W，通过 MyBatis
     */
    void import2DBFromExcel10wByMybatis(List<JobList> jobListList);
}
