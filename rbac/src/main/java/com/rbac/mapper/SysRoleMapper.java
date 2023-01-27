package com.rbac.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rbac.entity.SysRole;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleMapper extends BaseMapper<SysRole> {
    int updateBatch(List<SysRole> list);

    int batchInsert(@Param("list") List<SysRole> list);
}