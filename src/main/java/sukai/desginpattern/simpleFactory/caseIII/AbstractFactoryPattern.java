package sukai.desginpattern.simpleFactory.caseIII;

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        FactoryA factoryA = new FactoryA();
        FactoryB factoryB = new FactoryB();

        factoryA.ManufactureContainer().Show();
        factoryA.ManufactureModule().Show();

        factoryB.ManufactureContainer().Show();
        factoryB.ManufactureModule().Show();

    }
}
