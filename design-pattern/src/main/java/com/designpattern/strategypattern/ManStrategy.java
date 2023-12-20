package com.designpattern.strategypattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ManStrategy implements Strategy{
    @Override
    public void run() throws Exception {
      log.debug("Execute the logic related to men...");
    }
}
