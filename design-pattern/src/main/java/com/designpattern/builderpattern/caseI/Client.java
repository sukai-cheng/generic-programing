package com.designpattern.builderpattern.caseI;

public class Client {
    public static void main(String[] args) {

        Builder builder = new HouseBuilder();

        Director director = new Director(builder);

        System.out.println(director.direct());

        director.setBuilder(new ApartmentBuilder());

        System.out.println(director.direct());
    }
}
