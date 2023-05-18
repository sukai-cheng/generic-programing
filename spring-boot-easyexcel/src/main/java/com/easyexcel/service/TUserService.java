package com.easyexcel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.easyexcel.po.UserPO;

import java.util.List;

/**
 * @author chengsukai
 */
public interface TUserService extends IService<UserPO> {

    /**
     * 批量插入
     *
     */
    int batchInsert(List<UserPO> list);
}
