package com.seckill.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;

/**
    * 商品表
    */
@Data
@TableName(value = "t_goods")
public class TGoods {
    /**
     * 商品ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品名称
     */
    @TableField(value = "goods_name")
    private String goodsName;

    /**
     * 商品标题
     */
    @TableField(value = "goods_title")
    private String goodsTitle;

    /**
     * 商品图片
     */
    @TableField(value = "goods_img")
    private String goodsImg;

    /**
     * 商品详情
     */
    @TableField(value = "goods_detail")
    private String goodsDetail;

    /**
     * 商品价格
     */
    @TableField(value = "goods_price")
    private BigDecimal goodsPrice;

    /**
     * 商品库存，-1表示没有限制
     */
    @TableField(value = "goods_stock")
    private Integer goodsStock;
}