package sukai.desginpattern.simpleFactory.caseIII;

import sukai.desginpattern.simpleFactory.caseII.Product;

public class FactoryA extends Factory {
    @Override
    public AbstractProduct ManufactureContainer() {
        return new ContainerProductA();
    }

    @Override
    public AbstractProduct ManufactureModule() {
        return new ModuleProductA();
    }
}
