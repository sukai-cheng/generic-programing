package com.easyexcel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easyexcel.mapper.TUserMapper;
import com.easyexcel.po.UserPO;
import com.easyexcel.service.TUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chengsukai
 */
@Service
@Slf4j
public class TUserServiceImpl extends ServiceImpl<TUserMapper, UserPO> implements TUserService {
    @Override
    public int batchInsert(List<UserPO> list) {
        return baseMapper.batchInsert(list);
    }
}
