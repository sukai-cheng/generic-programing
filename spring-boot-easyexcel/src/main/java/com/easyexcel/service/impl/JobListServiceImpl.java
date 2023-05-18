package com.easyexcel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.easyexcel.service.JobListService;
import com.easyexcel.utils.JDBCHikariCPUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easyexcel.pojo.JobList;
import com.easyexcel.mapper.JobListMapper;

/**
 * @author chengsukai
 */
@Service
@Slf4j
public class JobListServiceImpl extends ServiceImpl<JobListMapper, JobList> implements JobListService {

    JDBCHikariCPUtils jdbcHikariCPUtils = new JDBCHikariCPUtils();

    @Override
    public int updateBatch(List<JobList> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<JobList> list) {

        return baseMapper.batchInsert(list);
    }

    @Override
    public List<JobList> findByPage100w(Integer pageNum, Integer pageSize) {
        PageInfo<JobList> pageInfo = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> {
            QueryWrapper<JobList> wrapper = new QueryWrapper<>();
            baseMapper.selectList(wrapper);
        });
        return pageInfo.getList();
    }

    @Override
    public Map<String, Object> import2DBFromExcel10wByJDBC(List<Map<Integer, String>> dataList) {

        Map<String, Object> result = new HashMap<>();
        if (dataList.size() == 0) {
            result.put("empty", "0000");
            return result;
        }

        Connection connection = null;
        PreparedStatement ps = null;
        try {
            long startTime = System.currentTimeMillis();
            log.info("{} 条,开始导入到数据库时间:{}", dataList.size(), startTime + "ms");
            jdbcHikariCPUtils.setConfig("hikari.properties");
            connection = jdbcHikariCPUtils.getConnection();
            // 控制事务:默认不提交
            connection.setAutoCommit(false);
            String sql = "insert into test.job_list (order_num, main_dept, institution_name, unit_nature, position_category, position_name, position_code, recruiters_num, needMajor_name, need_record, need_degree, need_other_condition, written_type, mark) VALUES";
            sql += "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = connection.prepareStatement(sql);
            for (Map<Integer, String> item : dataList) {
                ps.setString(1, item.get(0));
                ps.setString(2, item.get(1));
                ps.setString(3, item.get(2));
                ps.setString(4, item.get(3));
                ps.setString(5, item.get(4));
                ps.setString(6, item.get(5));
                ps.setString(7, item.get(6));
                ps.setString(8, item.get(7));
                ps.setString(9, item.get(8));
                ps.setString(10, item.get(9));
                ps.setString(11, item.get(10));
                ps.setString(12, item.get(11));
                ps.setString(13, item.get(12));
                ps.setString(14, item.get(13));
                ps.setString(15, item.get(14));
                ps.setString(16, item.get(15));
                ps.addBatch();
                connection.commit();
                long endTime = System.currentTimeMillis();
                log.info("{} 条,结束导入到数据库时间:{}", dataList.size(), endTime + "ms");
                log.info("{} 条,导入用时:{}", dataList.size(), (endTime - startTime) + "ms");
                result.put("success", "1111");
            }
        } catch (SQLException e) {
            result.put("exception", "0000");
            e.printStackTrace();
        } catch (IOException e) {
            // 关连接
            jdbcHikariCPUtils.close(connection, ps);
        }
        return result;
    }

    @Override
    public void import2DBFromExcel10wByMybatis(List<JobList> jobListList) {
        baseMapper.importToDb(jobListList);
    }
}
