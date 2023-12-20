package com.designpattern.strategypattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WomanStrategy implements Strategy{
    @Override
    public void run() throws Exception {
        log.debug("Execute women related logic...");
    }
}
