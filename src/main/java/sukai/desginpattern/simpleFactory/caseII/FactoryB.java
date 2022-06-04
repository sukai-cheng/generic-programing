package sukai.desginpattern.simpleFactory.caseII;

import sukai.desginpattern.simpleFactory.caseI.Product;
import sukai.desginpattern.simpleFactory.caseI.ProductB;

public class FactoryB extends Factory{
    @Override
    public Product Manufacture() {
        return new ProductB();
    }
}
