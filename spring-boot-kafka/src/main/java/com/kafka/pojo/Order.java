package com.kafka.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    /**
     * 订单ID
     */
    private long orderId;

    /**
     * 订单号
     */
    private String orderNum;

    /**
     * 订单创建时间
     */
    private LocalDateTime createTime;
}
