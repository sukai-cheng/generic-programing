package com.seckill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seckill.mapper.TOrderMapper;
import com.seckill.pojo.TOrder;
import com.seckill.pojo.TSeckillGoods;
import com.seckill.pojo.TSeckillOrder;
import com.seckill.pojo.TUser;
import com.seckill.service.TOrderService;
import com.seckill.service.TSeckillGoodsService;
import com.seckill.service.TSeckillOrderService;
import com.seckill.vo.GoodsVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements TOrderService {

    @Resource
    private TSeckillGoodsService seckillGoodsService;

    @Resource
    private TSeckillOrderService seckillOrderService;

    @Override
    public int updateBatch(List<TOrder> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<TOrder> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public TOrder seckill(TUser user, GoodsVo goodsVo) {
        TSeckillGoods seckillGoods = seckillGoodsService.getOne(new QueryWrapper<TSeckillGoods>().eq("goods_id", goodsVo.getId()));
        seckillGoods.setStockCount(seckillGoods.getStockCount() - 1);
        seckillGoodsService.updateById(seckillGoods);

        TOrder order = new TOrder();
        order.setOrderChannel((byte) 1);
        order.setCreateDate(new Date());
        order.setGoodsId(goodsVo.getId());
        order.setStatus((byte) 0);
        order.setDeliveryAddrId(0L);
        order.setGoodsCount(1);
        order.setGoodsName(goodsVo.getGoodsName());
        order.setGoodsPrice(seckillGoods.getSeckillPrice());
        order.setUserId(user.getId());
        order.setPayDate(new Date());
        save(order);

        TSeckillOrder seckillOrder = new TSeckillOrder();
        seckillOrder.setOrderId(order.getId());
        seckillOrder.setUserId(user.getId());
        seckillOrder.setGoodsId(goodsVo.getId());
        seckillOrderService.save(seckillOrder);

        return order;

    }
}
