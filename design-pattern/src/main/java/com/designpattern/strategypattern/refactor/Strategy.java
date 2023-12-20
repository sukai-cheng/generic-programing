package com.designpattern.strategypattern.refactor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum Strategy {

    MAN(0) {
        @Override
        public void run() {
            log.debug("Execute the logic related to men");
        }
    },

    WOMAN(1) {
        @Override
        public void run() {
            log.debug("Execute the logic related to women");
        }
    },

    OTHER(2) {
        @Override
        public void run() {
            log.debug("Execute the logic related to other");
        }
    };


   public abstract void run();

    public int statusCode;

    Strategy(int statusCode) {
        this.statusCode = statusCode;
    }
}
