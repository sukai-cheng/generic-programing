package com.seckill.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "t_order")
public class TOrder {
    /**
     * 订单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 商品ID
     */
    @TableField(value = "goods_id")
    private Long goodsId;

    /**
     * 收获地址ID
     */
    @TableField(value = "delivery_addr_id")
    private Long deliveryAddrId;

    /**
     * 商品名字
     */
    @TableField(value = "goods_name")
    private String goodsName;

    /**
     * 商品数量
     */
    @TableField(value = "goods_count")
    private Integer goodsCount;

    /**
     * 商品价格
     */
    @TableField(value = "goods_price")
    private BigDecimal goodsPrice;

    /**
     * 1 pc,2 android, 3 ios
     */
    @TableField(value = "order_channel")
    private Byte orderChannel;

    /**
     * 订单状态，0新建未支付，1已支付，2已发货，3已收货，4已退货，5已完成
     */
    @TableField(value = "`status`")
    private Byte status;

    /**
     * 订单创建时间
     */
    @TableField(value = "create_date")
    private Date createDate;

    /**
     * 支付时间
     */
    @TableField(value = "pay_date")
    private Date payDate;
}