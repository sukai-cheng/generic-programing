package sukai.network;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author chengsukai
 * @since 2022-12-28 13:58
 */
public class Proxy {
    public static void main(String[] args) {
        try {
            // 使用server sockert创建服务对象
            ServerSocket server = new ServerSocket(8082);
            while (true) {
                try {
                    Socket socket = server.accept();
                    new Thread(() -> {
                        try {
                            // 获取客户端输出
                            InputStream is = socket.getInputStream();
                            InputStreamReader inputStreamReader = new InputStreamReader(is);
                            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                            String line = bufferedReader.readLine();
                            String port_line = bufferedReader.readLine();
                            System.out.println(line);
                            System.out.println(port_line);
                            String CRLF = "\r\n";

                            String[] lineArr = line.split("/");
                            String lineCrr = lineArr[3];
                            String fileName = lineCrr.split(" ")[0];
                            System.out.println(fileName);
                            String[] lineBrr = lineArr[0].split(" ");
                            System.out.println("建立连接中....");
                            Socket socketServer = new Socket();
                            socketServer.connect(new InetSocketAddress("127.0.0.1", 8081), 10000);
                            OutputStream oss = socketServer.getOutputStream();
                            oss.write((lineBrr[0] + " /" + fileName + " HTTP/1.1" + CRLF).getBytes(StandardCharsets.UTF_8));
                            InputStream isServer = socketServer.getInputStream();
                            InputStreamReader isrServer = new InputStreamReader(isServer);
                            BufferedReader brServer = new BufferedReader(isrServer);
                            DataOutputStream os = new DataOutputStream(socket.getOutputStream());
                            String bs;
                            while ((bs = brServer.readLine()) != null) {
                                os.write((bs + CRLF).getBytes(StandardCharsets.UTF_8));
                            }
                            oss.close();
                            isServer.close();
                            isrServer.close();
                            brServer.close();
                            socketServer.close();
                            os.close();
                            socket.close();
                            bufferedReader.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }).start();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
