package sukai.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chengsukai
 * @since 2022-12-28 10:38
 */
public class ServerPlus {
    public static void main(String[] args) {
        try {

            // 使用ServerSocket
            ServerSocket server = new ServerSocket(8081);

            // loop waiting, keep receiving http req from client
            while (true) {
                // create socket receive req
                Socket socket = server.accept();

                new Thread(() -> {
                    try {
                        // receive input stream from http req
                        InputStream is = socket.getInputStream();
                        // converts a stream of bytes into a stream of characters
                        InputStreamReader isr = new InputStreamReader(is);
                        // 将字符流包成缓冲流提高读写效率
                        BufferedReader br = new BufferedReader(isr);
                        String line = br.readLine();
                        System.out.println(line);
                        String[] lineArr = line.split(" ");
                        String fileName = lineArr[1].substring(1);
                        if (fileName.equals("shutdown")) {
                            System.exit(0);
                        }
                        System.out.println(fileName);
                        String CRLF = "\r\n";

                        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
                        // 只有写入这一段代码，它才能在浏览器渲染成功
                        bos.write(("HTTP/1.1 200 OK" + CRLF).getBytes());
                        bos.write(("Content-type: " + "text/html" + CRLF).getBytes());
                        bos.write(CRLF.getBytes());

                        if (fileName.equals("index.html")) {
                            String absolutePath = "/Users/csk/Desktop/workspace/study/generic-programing/src/main/java/sukai/network/";
                            fileName = absolutePath + fileName;
                            FileInputStream fis = new FileInputStream(fileName);
                            BufferedInputStream bis = new BufferedInputStream(fis);
                            byte[] data = new byte[1024];
                            int length = 0;
                            // 当文件没有到末尾的时候，循环读取文件内容并写到服务器中
                            while ((length = bis.read(data)) != -1) {
                                bos.write(data, 0, length);
                            }
                            bis.close();
                        } else {
                            String entityBody = null;
                            entityBody = "<HTML>" +
                                    "<HEAD><TITLE>Not Found</TITLE></HEAD>" +
                                    "<BODY><h1>404 Not Found</BODY></h1></HTML>" +
                                    "</HTML>";
                            bos.write(entityBody.getBytes());
                        }
                        bos.close();
                        br.close();
                        socket.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
