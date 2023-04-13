package com.seckill.controller;

import com.seckill.pojo.TUser;
import com.seckill.service.TGoodsService;
import com.seckill.service.TUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    TUserService userService;

    @Resource
    TGoodsService goodsService;

    /**
     * 跳转到商品列表页面
     *
     */
    @RequestMapping("/toList")
    public String toList(Model model, TUser user) {
        model.addAttribute("user", user);
        model.addAttribute("goodsList",goodsService.findGoodsVo());
        return "goodsList";
    }

    /**
     * 跳转到商品细节页面
     *
     */
    @RequestMapping("/toDetail")
    public String toDetail(Model model, TUser user) {
        model.addAttribute("user", user);
        return "goodsList";
    }

}
