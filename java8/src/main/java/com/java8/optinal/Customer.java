package com.java8.optinal;

public class Customer {
    private Car car;

    public Customer(Car car) {
        this.car = car;
    }

    public Customer() {
    }

    public Car getCar() {
        return car;
    }
}
