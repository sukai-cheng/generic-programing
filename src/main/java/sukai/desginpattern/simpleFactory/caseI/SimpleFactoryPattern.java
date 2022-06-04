package sukai.desginpattern.simpleFactory.caseI;

import java.util.Objects;

public class SimpleFactoryPattern {
    public static void main(String[] args) {

        try{
            Objects.requireNonNull(Factory.Manufacture("A")).show();
        }catch (NullPointerException e){
            System.out.println("没有这一类产品");
        }
    }


}
