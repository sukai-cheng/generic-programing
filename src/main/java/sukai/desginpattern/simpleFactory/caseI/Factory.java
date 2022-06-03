package sukai.desginpattern.simpleFactory.caseI;

public class Factory {
    public static Product Manufacture(String ProductName) {
        switch (ProductName) {
            case "A":
                return new ProductA();
            case "B":
                return new ProductB();
            case "C":
                return new ProductC();
            default:
                return null;
        }
    }
}
