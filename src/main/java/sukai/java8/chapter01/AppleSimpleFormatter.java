package sukai.java8.chapter01;

public class AppleSimpleFormatter implements AppleFormat
{
    @Override
    public String accept(Apple apple) {
        return "An apple of " + apple.getWeight() + "g";
    }
}
