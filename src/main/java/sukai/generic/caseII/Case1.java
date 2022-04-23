package sukai.generic.caseII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description 范型编程
 *
 * @author chengsukai
 *
 * @create 2022-04-04 00:11
 **/
public class Case1 {

    public static void main(String[] args) {

        final Plant plant = new Plant();

        Herbivore herbivore = new Herbivore();

        final Carnivore carnivore = new Carnivore();
        Carnivore carnivore2 = new Carnivore();
        carnivore.eat(herbivore);
        carnivore.eat(carnivore2);

        List<Biology<?>> biologies = Arrays.asList(plant, herbivore, carnivore, carnivore2);

        List<Biology<?>> biologies2 = new ArrayList<>();

        List<? extends Biology<?>> biologies3 = new ArrayList<>();
        List<? super Biology<?>> biologies4 = new ArrayList<>();

        for (Biology<?> biology : biologies) {
            final Biology<?> spawn = biology.spawn();
            biologies2.add(spawn);
//            biologies3.add(spawn); // todo error
            biologies4.add(spawn); // todo why this is right
        }

    }

    public static <T extends Biology<T>> Biology<T> getCarnivore() {
        return (Biology<T>) new Carnivore();
    }

    static abstract class Biology<T extends Biology<T>> {

        abstract T spawn();

    }

    static abstract class Animal<S extends Biology<?>> extends Biology<Animal<S>> {
        abstract void eat(S food);
    }

    static class Carnivore extends Animal<Animal<?>> {

        @Override
        Carnivore spawn() {
            return new Carnivore();
        }

        @Override
        void eat(Animal<?> food) {

        }
    }

    static class Herbivore extends Animal<Plant> {

        @Override
        Herbivore spawn() {
            return new Herbivore();
        }


        @Override
        void eat(Plant food) {

        }
    }

    static class Plant extends Biology<Plant> {

        @Override
        Plant spawn() {
            return null;
        }
    }
}