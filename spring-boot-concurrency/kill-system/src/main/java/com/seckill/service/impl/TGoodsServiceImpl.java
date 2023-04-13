package com.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seckill.mapper.TGoodsMapper;
import com.seckill.pojo.TGoods;
import com.seckill.service.TGoodsService;
import com.seckill.vo.GoodsVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TGoodsServiceImpl extends ServiceImpl<TGoodsMapper, TGoods> implements TGoodsService{

    @Resource
    private TGoodsMapper goodsMapper;

    @Override
    public int updateBatch(List<TGoods> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<TGoods> list) {
        return baseMapper.batchInsert(list);
    }

    /**
     * 功能描述: 获取商品列表
     */
    @Override
    public List<GoodsVo> findGoodsVo() {
        return goodsMapper.findGoodsVo();
    }

    @Override
    public GoodsVo findGoodsVoByGoodsId(Long goodsId) {
        return goodsMapper.findGoodsVoByGoodsId(goodsId);
    }
}
