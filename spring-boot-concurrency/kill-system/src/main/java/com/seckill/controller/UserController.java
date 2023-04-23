package com.seckill.controller;

import com.seckill.pojo.TUser;
import com.seckill.rabbit.MQSender;
import com.seckill.vo.RespBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author chengsukai
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private MQSender mqSender;

    @RequestMapping("/info")
    @ResponseBody
    public RespBean info(TUser user) {
        return RespBean.success(user);
    }

    @RequestMapping("/mq")
    @ResponseBody
    public void mq(){
        mqSender.send("Hello");
    }
}
