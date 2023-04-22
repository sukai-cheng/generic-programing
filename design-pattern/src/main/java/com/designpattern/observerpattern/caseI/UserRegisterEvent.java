package com.designpattern.observerpattern.caseI;

import org.springframework.context.ApplicationEvent;

import java.io.Serial;

/**
 * @author chengsukai
 */
public class UserRegisterEvent extends ApplicationEvent {

    @Serial
    private static final long serialVersionUID = 8349967627859975141L;

    private String username;

    public UserRegisterEvent(Object source) {
        super(source);
    }

    public UserRegisterEvent(Object source, String username) {
        super(source);
        this.username = username;
    }


}
