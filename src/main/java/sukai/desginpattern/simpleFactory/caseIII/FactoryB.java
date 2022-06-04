package sukai.desginpattern.simpleFactory.caseIII;

public class FactoryB extends Factory {


    @Override
    public AbstractProduct ManufactureContainer() {
        return new ContainerProductB();
    }

    @Override
    public AbstractProduct ManufactureModule() {
        return new ModuleProductB();
    }
}