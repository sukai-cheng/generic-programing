package sukai.desginpattern.simpleFactory.caseII;

import sukai.desginpattern.simpleFactory.caseI.Product;
import sukai.desginpattern.simpleFactory.caseI.ProductA;

public class FactoryA extends Factory{
    @Override
    public Product Manufacture() {
       return new ProductA();
    }
}
