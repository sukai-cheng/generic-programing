package com.easyexcel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.easyexcel.pojo.ActResultLogDO;

import java.util.List;
import java.util.Map;

public interface ActResultLogService extends IService<ActResultLogDO> {


    /**
     * 批量更新
     */
    int updateBatch(List<ActResultLogDO> list);

    /**
     * 批量插入
     *
     */
    int batchInsert(List<ActResultLogDO> list);

    /**
     * 通过分页参数查询一百w数据
     */
    List<ActResultLogDO> findByPage100w(Integer pageNum, Integer pageSize);

    /**
     * 从 Excel 导入数据，批次为 10w，通过 JDBC
     */
    Map<String, Object> import2DBFromExcel10wByJDBC(List<Map<Integer, String>> dataList);

    /**
     * 从 Excel 导入数据，批次为 10W，通过 MyBatis
     */
    void import2DBFromExcel10wByMybatis(List<ActResultLogDO> actResultLogList);
}
