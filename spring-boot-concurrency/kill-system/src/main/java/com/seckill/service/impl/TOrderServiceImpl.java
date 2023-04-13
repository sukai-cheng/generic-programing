package com.seckill.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.seckill.pojo.TOrder;
import com.seckill.mapper.TOrderMapper;
import com.seckill.service.TOrderService;
@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements TOrderService{

    @Override
    public int updateBatch(List<TOrder> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<TOrder> list) {
        return baseMapper.batchInsert(list);
    }
}
