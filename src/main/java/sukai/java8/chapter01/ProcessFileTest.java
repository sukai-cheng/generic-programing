package sukai.java8.chapter01;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProcessFileTest {

    public static String processFile(@NotNull BufferReaderProcessor processor) throws
            IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("src/main/java/sukai/java8/chapter01/data.txt"))) {
            return processor.process(br);
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(processFile((BufferedReader br) -> {
            return br.readLine() + "\n" + br.readLine();
        }));
    }
}
