package sukai.currencyBasic.chapter06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author chengsukai
 * @since 2022-08-23 16:48
 */
public class _04_PreventDuplicated {
    private final static String LOCK_PATH = "/Users/csk/Desktop/workspace/study/generic-programing/src/main/resources/locks";
    private final static String LOCK_FILE = ".lock";
    private final static String PERMISSIONS = "rw-------";

    public static void main(String[] args) throws IOException {
        // 注入Hook线程
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("The program received kill SIGNAL");
            // delete file
            getLockFile().toFile().delete();
        }));
        checkRunning();
        for (; ; ) {
            try {
                TimeUnit.MILLISECONDS.sleep(1);
                System.out.println("program is running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void checkRunning() throws IOException {
        Path path = getLockFile();
        if (path.toFile().exists()) {
            throw new RuntimeException("The program already running");
        }
        Set<PosixFilePermission> perms = PosixFilePermissions.fromString(PERMISSIONS);
        Files.createFile(path, PosixFilePermissions.asFileAttribute(perms));
    }

    private static Path getLockFile() {
        return Paths.get(LOCK_PATH, LOCK_FILE);
    }
}
