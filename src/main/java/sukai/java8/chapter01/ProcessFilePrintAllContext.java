package sukai.java8.chapter01;

import java.io.BufferedReader;
import java.io.IOException;

public class ProcessFilePrintAllContext implements BufferReaderProcessor {
    @Override
    public String process(BufferedReader bufferedReader) throws IOException {
        String reader;
        StringBuilder sb = new StringBuilder();
        while ((reader = bufferedReader.readLine()) != null) {
            sb.append(reader);
            sb.append('\n');
        }
        return sb.toString();
    }
}
