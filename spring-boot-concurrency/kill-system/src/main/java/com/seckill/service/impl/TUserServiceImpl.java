package com.seckill.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.seckill.mapper.TUserMapper;
import com.seckill.pojo.TUser;
import com.seckill.service.TUserService;
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService{

    @Override
    public int updateBatch(List<TUser> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<TUser> list) {
        return baseMapper.batchInsert(list);
    }
}
