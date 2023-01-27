package com.rbac.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rbac.entity.SysUserRole;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
    int updateBatch(List<SysUserRole> list);

    int batchInsert(@Param("list") List<SysUserRole> list);
}