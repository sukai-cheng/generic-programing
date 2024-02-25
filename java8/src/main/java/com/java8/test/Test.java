package com.java8.test;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class Test {
    public static void main(String[] args) {
//        Integer i = new Integer(128);
//        int j = 128;
//        System.out.println(i == j);
//
//        Student s1 = new Student(10);
//        Student s2 = new Student(10);
//        System.out.println(s1.equals(s2));

        calEscapeTime("");
        calEscapeTime(new StringBuffer());
        calEscapeTime(new StringBuilder());



    }


    private static void calEscapeTime(String str){
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++){
            str = str + i;
        }
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        log.info("String消耗时间: " + time);
    }

    private static void calEscapeTime(StringBuffer str){
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++){
            str.append(i);
        }
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        log.info("StringBuffer消耗时间: " + time);
    }

    private static void calEscapeTime(StringBuilder str){
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++){
            str.append(i);
        }
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        log.info("StringBuilder消耗时间: " + time);
    }


}
class Student {
    private int age;

    public Student(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                '}';
    }
}