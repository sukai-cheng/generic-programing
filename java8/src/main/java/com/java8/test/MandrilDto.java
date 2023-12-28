package com.java8.test;

import lombok.Data;

@Data
public class MandrilDto {
    /**
     * 测试工厂
     */
    String Werks;
    /**
     * 母棒编号
     */
    String Original_Lot;
    /**
     * 批次编号twentyForthCell
     */
    String Lot;
    /**
     * 物料编号
     */
    String Matnr;

    String FAOppucy;
    /**
     * 产品类别
     */
    String fTargetManufactureType;

    /**
     * 开始位置
     */
    String fRootBeginPosition;
    /**
     * 结束位置
     */
    String fRootEndPosition;
    /**
     * 长度
     */
    String fLength;
}
