package com.java8.io;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;

public class ioTest {
    public static void main(String[] args) throws IOException {
//        testInput();
        testOutput();
//        Resource resource = new ClassPathResource("files");
//        String path = String.valueOf(resource.getURL());
//        System.out.println(path);
    }

    public static void testInput() {
//        InputStream inputStream = null;
        // try-catch-finally
//        try {
//            ClassPathResource cpr = new ClassPathResource("files.txt");
//            inputStream = cpr.getInputStream();
//            int data = inputStream.read();
//            System.out.println("data->: " + data);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                inputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        // try-resource
        try (InputStream inputStream = new ClassPathResource("files/files.txt").getInputStream()) {
            int data = inputStream.read();
            System.out.println("data->: " + data);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void testOutput() throws IOException {

        Resource resource = new ClassPathResource("files/filesTest.txt");
        String path = resource.getURL().getPath();
        System.out.println(path);

        try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            fileOutputStream.write(1);
            fileOutputStream.write(new byte[]{2, 3, 4});
        }
    }


}
