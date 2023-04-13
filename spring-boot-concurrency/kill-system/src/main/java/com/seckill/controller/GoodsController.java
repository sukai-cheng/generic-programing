package com.seckill.controller;

import com.seckill.pojo.TGoods;
import com.seckill.pojo.TUser;
import com.seckill.service.TGoodsService;
import com.seckill.service.TUserService;
import com.seckill.vo.GoodsVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    TUserService userService;

    @Resource
    TGoodsService goodsService;

    /**
     * 跳转到商品列表页面
     */
    @RequestMapping("/toList")
    public String toList(Model model, TUser user) {
        model.addAttribute("user", user);
        model.addAttribute("goodsList", goodsService.findGoodsVo());
        return "goodsList";
    }

    /**
     * 跳转到商品细节页面
     */
    @RequestMapping("/toDetail")
    public String toDetail(Model model, TUser user) {
        model.addAttribute("user", user);
        return "goodsList";
    }

    @RequestMapping("toDetail/{goodsId}")
    public String toDetail(Model model, TUser user, @PathVariable Long goodsId) {
        model.addAttribute("user", user);
        GoodsVo goods = goodsService.findGoodsVoByGoodsId(goodsId);
        Date startDate = goods.getStartDate();
        Date endDate = goods.getEndDate();
        int remainSeconds = 0;
        Date nowDate = new Date();
        int secKillStatus = 0;
        // 秒杀还未开始
        if (nowDate.before(startDate)) {
            remainSeconds = (int) ((startDate.getTime() - nowDate.getTime()) / 1000);
        } else if (nowDate.after(endDate)) {
            // 秒杀已经结束
            secKillStatus = 2;
            remainSeconds = -1;
        } else {
            secKillStatus = 1;
        }
        model.addAttribute("secKillStatus", secKillStatus);
        model.addAttribute("remainSeconds", remainSeconds);
        model.addAttribute("goods", goods);
        return "goodsDetail";
    }

}
