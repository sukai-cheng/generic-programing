package com.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.easyexcel.constants.ExcelConstants;
import com.easyexcel.pojo.ActResultLogDO;
import com.easyexcel.pojo.ActResultLogVO;
import com.easyexcel.service.ActResultLogService;
import com.easyexcel.utils.StarBeanUtils;

import java.util.ArrayList;
import java.util.List;

public class EasyExcelGeneralDataMybatisListener extends AnalysisEventListener<ActResultLogVO> {
    private ActResultLogService actResultLogService;

    /**
     * 用于存储读取的数据
     */
    private List<ActResultLogVO> dataList = new ArrayList<>();

    public EasyExcelGeneralDataMybatisListener() {

    }

    public EasyExcelGeneralDataMybatisListener(ActResultLogService actResultLogService) {
        this.actResultLogService = actResultLogService;
    }

    @Override
    public void invoke(ActResultLogVO data, AnalysisContext context) {
        // 数据add进入集合
        dataList.add(data);
        // size是否为100000条:这里其实就是分批.当数据等于10w的时候执行一次插入
        if (dataList.size() >= ExcelConstants.GENERAL_ONCE_SAVE_TO_DB_ROWS_JDBC) {
            // 存入数据库:数据小于 1w 条使用 Mybatis 批量插入即可
            saveData();
            // 清理集合便于GC回收
            dataList.clear();
        }
    }

    /**
     * 保存数据到 DB
     */
    private void saveData() {
        if (dataList.size() > 0) {
            actResultLogService.import2DBFromExcel10wByMybatis(StarBeanUtils.copyList(dataList, ActResultLogDO.class));
            dataList.clear();
        }
    }

    /**
     * Excel 中所有数据解析完毕会调用此方法
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        saveData();
        dataList.clear();
    }
}
