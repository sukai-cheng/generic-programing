package com.java8.optinal;

public class MainTest2 {
    public static void main(String[] args) {
        Customer customer = new Customer();
        Make make = getCustomerCarMake(customer);
        System.out.println(make != null ? make.name() : null);
    }

    public static Make getCustomerCarMake(Customer customer) {
        if(customer == null && customer.getCar() != null) {
            return customer.getCar().getMake();
        }
        return null;
    }
}
