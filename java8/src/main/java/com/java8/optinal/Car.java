package com.java8.optinal;

public class Car {
    private Make make;

    Car(Make make) {
        this.make = make;
    }

    public Car() {
    }

    public Make getMake() {
        return make;
    }
}
