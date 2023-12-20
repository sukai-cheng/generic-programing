package com.designpattern.strategypattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OtherStrategy implements Strategy{
    @Override
    public void run() throws Exception {
        log.debug("Execute other related logic...");
    }
}
