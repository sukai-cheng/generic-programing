package com.rbac.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rbac.entity.SysMenu;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysMenuMapper extends BaseMapper<SysMenu> {
    int updateBatch(List<SysMenu> list);

    int batchInsert(@Param("list") List<SysMenu> list);
}