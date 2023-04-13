package com.seckill.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
    * 秒杀商品表
    */
@Data
@TableName(value = "t_seckill_goods")
public class TSeckillGoods {
    /**
     * 秒杀商品ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品ID
     */
    @TableField(value = "goods_id")
    private Long goodsId;

    /**
     * 秒杀家
     */
    @TableField(value = "seckill_price")
    private BigDecimal seckillPrice;

    /**
     * 库存数量
     */
    @TableField(value = "stock_count")
    private Integer stockCount;

    /**
     * 秒杀开始时间
     */
    @TableField(value = "start_date")
    private Date startDate;

    /**
     * 秒杀结束时间
     */
    @TableField(value = "end_date")
    private Date endDate;
}