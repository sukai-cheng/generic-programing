package sukai.desginpattern.simpleFactory.caseII;

public class FactoryPattern {
    public static void main(String[] args) {
        FactoryA factoryA = new FactoryA();
        factoryA.Manufacture().show();

        FactoryB factoryB = new FactoryB();
        factoryB.Manufacture().show();
    }
}
