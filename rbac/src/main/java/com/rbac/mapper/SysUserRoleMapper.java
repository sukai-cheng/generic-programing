package com.rbac.mapper;

import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import com.rbac.entity.SysUserRole;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserRoleMapper extends MppBaseMapper<SysUserRole> {
    int updateBatch(List<SysUserRole> list);

    int batchInsert(@Param("list") List<SysUserRole> list);
}