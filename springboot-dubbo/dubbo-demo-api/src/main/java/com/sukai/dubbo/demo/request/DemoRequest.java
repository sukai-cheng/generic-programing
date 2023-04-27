package com.sukai.dubbo.demo.request;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author chengsukai
 */
@Data
public class DemoRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = -9132451624810766026L;

    String username;
    String password;
}
