package com.rbac.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rbac.entity.SysRoleMenu;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {
    int updateBatch(List<SysRoleMenu> list);

    int batchInsert(@Param("list") List<SysRoleMenu> list);
}