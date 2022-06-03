package sukai.desginpattern.simpleFactory.caseI;

public class SimpleFactoryPattern {
    public static void main(String[] args) {
        Factory mFactory = new Factory();

        try{
            mFactory.Manufacture("A").show();
        }catch (NullPointerException e){
            System.out.println("没有这一类产品");
        }
    }


}
