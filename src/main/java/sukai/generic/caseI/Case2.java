package sukai.generic.caseI;

/**
 * @description 范型编程
 *
 * @author chengsukai
 *
 * @create 2022-04-04 00:11
 **/
public class Case2 {

    public static void main(String[] args) {

        final Biology carnivore1 = getCarnivore();
        final Biology spawn = carnivore1.spawn();
        ((Carnivore) spawn).eat();

        final Carnivore carnivore2 = new Carnivore();
        Carnivore carnivore3 = carnivore2.spawn();
        carnivore3.eat();
    }

    public static Biology getCarnivore() {
        return new Carnivore();
    }

    static abstract class Biology {

        abstract Biology spawn();

    }

    static class Carnivore extends Biology {

        @Override
        Carnivore spawn() {
            return new Carnivore();
        }

        void eat() {

        }
    }

    static class Herbivore extends Biology {

        @Override
        Herbivore spawn() {
            return new Herbivore();
        }

        void eat(Object obj) {

        }
    }
}