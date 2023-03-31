package com.seckill.service;

import java.util.List;
import com.seckill.pojo.TUser;
import com.baomidou.mybatisplus.extension.service.IService;
public interface TUserService extends IService<TUser>{


    int updateBatch(List<TUser> list);

    int batchInsert(List<TUser> list);

}
