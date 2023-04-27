package com.sukai.dubbo.demo.response;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author chengsukai
 */
@Data
public class DemoResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = -5987181182770379265L;

    String message;

    String status;
}
