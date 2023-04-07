package com.seckill.service.impl;

import com.seckill.exception.GlobalException;
import com.seckill.utils.MD5Util;
import com.seckill.utils.ValidatorUtil;
import com.seckill.vo.LoginVo;
import com.seckill.vo.ResBeanEnum;
import com.seckill.vo.RespBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import com.seckill.mapper.TUserMapper;
import com.seckill.pojo.TUser;
import com.seckill.service.TUserService;

@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

    @Resource
    private TUserMapper userMapper;

    @Override
    public int updateBatch(List<TUser> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<TUser> list) {
        return baseMapper.batchInsert(list);
    }

    /**
     * 功能描述: 登陆
     *
     * @param loginVo
     * @return
     */
    @Override
    public RespBean doLogin(LoginVo loginVo) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();

        TUser user = userMapper.selectById(mobile);

        if (null == user) {
            throw new GlobalException(ResBeanEnum.LOGIN_ERROR);
        }

        if (!MD5Util.inputPass2DataBasePass(password, user.getSalt()).equals(user.getPassword())) {
            throw new GlobalException(ResBeanEnum.LOGIN_ERROR);
        }

        return RespBean.success();

    }

}



















