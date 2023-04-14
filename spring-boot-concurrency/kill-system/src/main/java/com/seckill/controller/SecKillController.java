package com.seckill.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seckill.pojo.TOrder;
import com.seckill.pojo.TSeckillOrder;
import com.seckill.pojo.TUser;
import com.seckill.service.TGoodsService;
import com.seckill.service.TOrderService;
import com.seckill.service.TSeckillOrderService;
import com.seckill.vo.GoodsVo;
import com.seckill.vo.ResBeanEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/seckill")
public class SecKillController {

    @Resource
    private TGoodsService goodsService;

    @Resource
    private TSeckillOrderService seckillOrderService;

    @Resource
    private TOrderService orderService;

    @RequestMapping("/doSeckill")
    public String doSeckill(Model model, TUser user, Long goodsId) {

        if (user == null) {
            return "login";
        }

        model.addAttribute("user", user);

        GoodsVo goodsVo = goodsService.findGoodsVoByGoodsId(goodsId);

        if (goodsVo.getStockCount() < 1) {
            model.addAttribute("errmsg", ResBeanEnum.EMPTY_STOCK.getMessage());
            return "secKillFail";
        }

        TSeckillOrder secKillOrder = seckillOrderService.getOne(new QueryWrapper<TSeckillOrder>().eq("user_id", user.getId()).eq("goods_id", goodsId));

        if(secKillOrder != null){
            model.addAttribute("errmsg",ResBeanEnum.REPEATE.getMessage());
            return "secKillFail";
        }

        TOrder order = orderService.seckill(user,goodsVo);
        model.addAttribute("order",order);
        model.addAttribute("goods",goodsVo);

        return "orderDetail";
    }
}
