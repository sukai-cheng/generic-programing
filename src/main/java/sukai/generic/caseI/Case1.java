package sukai.generic.caseI;

/**
 * @description 范型编程
 *
 * @author chengsukai
 *
 * @create 2022-04-04 00:11
 **/
public class Case1 {

    public static void main(String[] args) {

        final Biology carnivore1 = getCarnivore();
        final Biology spawn = carnivore1.spawn();
        ((Carnivore) spawn).eat();

        final Carnivore carnivore2 = new Carnivore();
        Biology carnivore3 = carnivore2.spawn();
        ((Carnivore) carnivore3).eat();
    }

    public static Biology getCarnivore() {
        return new Carnivore();
    }

    static abstract class Biology {

        abstract Biology spawn();

    }

    static class Carnivore extends Biology {

        @Override
        Biology spawn() {
            return new Carnivore();
        }

        void eat() {

        }
    }

    static class Herbivore extends Biology {

        @Override
        Biology spawn() {
            return new Herbivore();
        }

        void eat(Object obj) {

        }
    }
}