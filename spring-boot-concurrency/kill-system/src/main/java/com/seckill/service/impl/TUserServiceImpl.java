package com.seckill.service.impl;

import com.seckill.exception.GlobalException;
import com.seckill.utils.CookieUtil;
import com.seckill.utils.MD5Util;
import com.seckill.utils.UUIDUtil;
import com.seckill.utils.ValidatorUtil;
import com.seckill.vo.LoginVo;
import com.seckill.vo.ResBeanEnum;
import com.seckill.vo.RespBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
     */
    @Override
    public RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();

        TUser user = userMapper.selectById(mobile);

        if (null == user) {
            throw new GlobalException(ResBeanEnum.LOGIN_ERROR);
        }

        if (!MD5Util.inputPass2DataBasePass(password, user.getSalt()).equals(user.getPassword())) {
            throw new GlobalException(ResBeanEnum.LOGIN_ERROR);
        }
        // 生成cookie
        String ticket = UUIDUtil.uuid();
        // 将用户对象存入cookie
        request.getSession().setAttribute(ticket,user);
        // 将UUID存入cookie中
        CookieUtil.setCookie(request,response,"userTicket",ticket);
        return RespBean.success();

    }

}



















