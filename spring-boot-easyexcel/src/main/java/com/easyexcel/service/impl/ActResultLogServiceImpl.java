package com.easyexcel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easyexcel.mapper.ActResultLogMapper;
import com.easyexcel.pojo.ActResultLogDO;
import com.easyexcel.service.ActResultLogService;
import com.easyexcel.utils.JDBCHikariCPUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ActResultLogServiceImpl extends ServiceImpl<ActResultLogMapper, ActResultLogDO> implements ActResultLogService {

    JDBCHikariCPUtils jdbcHikariCPUtils = new JDBCHikariCPUtils();

    @Override
    public int updateBatch(List<ActResultLogDO> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<ActResultLogDO> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public List<ActResultLogDO> findByPage100w(Integer pageNum, Integer pageSize) {
        PageInfo<ActResultLogDO> pageInfo = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> {
            QueryWrapper<ActResultLogDO> wrapper = new QueryWrapper<>();
            // TODO 此处可以进行添加条件过滤
            baseMapper.selectList(wrapper);
        });
        return pageInfo.getList();
    }

    @Override
    public Map<String, Object> import2DBFromExcel10wByJDBC(List<Map<Integer, String>> dataList) {
        Map<String, Object> result = new HashMap<>();
        // 结果集中数据为0时,结束方法.进行下一次调用
        if (dataList.size() == 0) {
            result.put("empty", "0000");
            return result;
        }
        // JDBC分批插入+事务操作完成对10w数据的插入
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            long startTime = System.currentTimeMillis();
            log.info("{} 条,开始导入到数据库时间:{}", dataList.size(), startTime + "ms");
            jdbcHikariCPUtils.setConfig("hikari.properties");
            conn = jdbcHikariCPUtils.getConnection();
            // 控制事务:默认不提交
            conn.setAutoCommit(false);
            String sql = "insert into ACT_RESULT_LOG (onlineseqid,businessid,becifno,ivisresult,createdby,createddate,updateby,updateddate,risklevel) values";
            sql += "(?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            // 循环结果集:这里循环不支持"烂布袋"表达式
            for (Map<Integer, String> item : dataList) {
                ps.setString(1, item.get(0));
                ps.setString(2, item.get(1));
                ps.setString(3, item.get(2));
                ps.setString(4, item.get(3));
                ps.setString(5, item.get(4));
                ps.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
                ps.setString(7, item.get(6));
                ps.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
                ps.setString(9, item.get(8));
                // 将一组参数添加到此 PreparedStatement 对象的批处理命令中。
                ps.addBatch();
            }
            // 执行批处理
            ps.executeBatch();
            // 手动提交事务
            conn.commit();
            long endTime = System.currentTimeMillis();
            log.info("{} 条,结束导入到数据库时间:{}", dataList.size(), endTime + "ms");
            log.info("{} 条,导入用时:{}", dataList.size(), (endTime - startTime) + "ms");
            result.put("success", "1111");
        } catch (Exception e) {
            result.put("exception", "0000");
            e.printStackTrace();
        } finally {
            // 关连接
            jdbcHikariCPUtils.close(conn, ps);
        }
        return result;
    }

    @Override
    public void import2DBFromExcel10wByMybatis(List<ActResultLogDO> actResultLogList) {
        baseMapper.importToDb(actResultLogList);
    }
}
