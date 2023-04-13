package com.seckill.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seckill.mapper.TSeckillGoodsMapper;
import java.util.List;
import com.seckill.pojo.TSeckillGoods;
import com.seckill.service.TSeckillGoodsService;
@Service
public class TSeckillGoodsServiceImpl extends ServiceImpl<TSeckillGoodsMapper, TSeckillGoods> implements TSeckillGoodsService{

    @Override
    public int updateBatch(List<TSeckillGoods> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<TSeckillGoods> list) {
        return baseMapper.batchInsert(list);
    }
}
