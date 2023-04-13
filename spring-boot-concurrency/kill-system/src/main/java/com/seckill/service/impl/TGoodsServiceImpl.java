package com.seckill.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seckill.mapper.TGoodsMapper;
import java.util.List;
import com.seckill.pojo.TGoods;
import com.seckill.service.TGoodsService;
@Service
public class TGoodsServiceImpl extends ServiceImpl<TGoodsMapper, TGoods> implements TGoodsService{

    @Override
    public int updateBatch(List<TGoods> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<TGoods> list) {
        return baseMapper.batchInsert(list);
    }
}
