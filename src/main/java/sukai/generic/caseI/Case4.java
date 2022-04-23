package sukai.generic.caseI;

/**
 * @description 范型编程
 *
 * @author chengsukai
 *
 * @create 2022-04-04 00:11
 **/
public class Case4 {

    public static void main(String[] args) {

        Biology<Carnivore> carnivore1 = getCarnivore();
        Carnivore spawn = carnivore1.spawn();
        spawn.eat();

        final Carnivore carnivore2 = new Carnivore();
        Carnivore carnivore3 = carnivore2.spawn();
        carnivore3.eat();
    }

    public static <T extends Biology<T>> Biology<T> getCarnivore() {
        return (Biology<T>) new Carnivore();
    }

    static abstract class Biology<T extends Biology<T>> {

        abstract T spawn();

    }

    static class Carnivore extends Biology<Carnivore> {


        void eat() {

        }

        @Override
        Carnivore spawn() {
            return new Carnivore();
        }
    }

    static class Herbivore extends Biology<Herbivore> {

        @Override
        Herbivore spawn() {
            return new Herbivore();
        }

        void eat(Object obj) {

        }
    }
}