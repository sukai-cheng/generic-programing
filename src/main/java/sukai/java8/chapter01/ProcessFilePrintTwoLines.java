package sukai.java8.chapter01;

import java.io.BufferedReader;
import java.io.IOException;

public class ProcessFilePrintTwoLines implements BufferReaderProcessor{
    @Override
    public String process(BufferedReader bufferedReader) throws IOException {
        return bufferedReader.readLine() + bufferedReader.readLine();
    }
}
