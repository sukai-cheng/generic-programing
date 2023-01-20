package sukai.java8.chapter01;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferReaderProcessor {
    String process(BufferedReader bufferedReader) throws IOException;
}
