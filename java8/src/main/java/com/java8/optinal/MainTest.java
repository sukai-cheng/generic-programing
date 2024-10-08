package com.java8.optinal;

public class MainTest {
    public static void main(String[] args) {
        Customer customer = new Customer();
        System.out.println(getCustomerCarMake(customer));
    }

    public static Make getCustomerCarMake(Customer customer) {
        return customer.getCar().getMake();
    }
}
