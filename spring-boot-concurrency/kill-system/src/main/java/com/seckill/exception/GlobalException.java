package com.seckill.exception;

import com.seckill.vo.ResBeanEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -3299890087609452098L;
    private ResBeanEnum respBeanEnum;
}
