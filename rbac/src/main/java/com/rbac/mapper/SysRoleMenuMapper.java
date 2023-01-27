package com.rbac.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import com.rbac.entity.SysRoleMenu;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleMenuMapper extends MppBaseMapper<SysRoleMenu> {
    int updateBatch(List<SysRoleMenu> list);

    int batchInsert(@Param("list") List<SysRoleMenu> list);
}