package sukai.classloader;

import java.io.*;

/**
 * custom define classloader
 *
 * @author chengsukai
 * @since 2022-12-27 12:09
 */
public class TestClassLoader extends ClassLoader {
    public TestClassLoader(ClassLoader classLoader) {
        super(classLoader);
    }

    @Override
    protected Class findClass(String name) throws ClassNotFoundException {
        // 1、获取class文件二进制字节数组
        byte[] data = null;
        try {
            System.out.println(name);
            String namePath = name.replaceAll("\\.", "\\\\");
            String classFile = "C:\\study\\myStudy\\ZooKeeperLearning\\zkops\\target\\classes\\" + namePath + ".class";
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            FileInputStream fis = new FileInputStream(classFile);
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fis.read(bytes)) != -1) {
                baos.write(bytes, 0, len);
            }
            data = baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 2、字节码加载到 JVM 的方法区，
        // 并在 JVM 的堆区建立一个java.lang.Class对象的实例
        // 用来封装 Java 类相关的数据和方法
        return this.defineClass(name, data, 0, data.length);
    }

    public static void main(String[] args) {
        System.out.println("\\.");
        String name = "Users.csk";
        // 但是'\'也是正则表达式中的转义字符（replaceAll 的参数就是正则表达式），需要用两个代表一个。所以：\\\\被java转换成\\，\\又被正则表达式转换成\。
        String namePath = name.replaceAll("\\.", "\\\\");
        System.out.println(namePath);
    }
}
