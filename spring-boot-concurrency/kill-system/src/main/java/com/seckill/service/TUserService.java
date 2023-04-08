package com.seckill.service;

import java.util.List;
import com.seckill.pojo.TUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.seckill.vo.LoginVo;
import com.seckill.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface TUserService extends IService<TUser>{


    int updateBatch(List<TUser> list);

    int batchInsert(List<TUser> list);

    RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);
}
