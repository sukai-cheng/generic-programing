package com.seckill.utils;


import com.seckill.pojo.TUser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成用户工具类
 *
 * @author: LC
 * @date 2022/3/4 3:29 下午
 * @ClassName: UserUtil
 */
public class UserUtil {

    private static void createUser(int count) throws ClassNotFoundException, SQLException, IOException {
        List<TUser> users = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            TUser user = new TUser();
            user.setId(1300000000L + i);
            user.setNickname("user" + i);
            user.setSalt("1a2b3c");
            user.setPassword(MD5Util.inputPass2DataBasePass("123456", user.getSalt()));
            users.add(user);
        }
        System.out.println("create user");
        // 插入数据库操作
        Connection conn = getConn();
        String sql = "insert into t_user(login_count,nickname,register_date, salt, password, id) values (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        for (TUser user : users) {
            preparedStatement.setInt(1, user.getLoginCount());
            preparedStatement.setString(2, user.getNickname());
            preparedStatement.setTimestamp(3, new Timestamp(user.getRegisterDate().getTime()));
            preparedStatement.setString(4, user.getSalt());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setLong(6, user.getId());
        }
        preparedStatement.executeBatch();
        preparedStatement.clearParameters();
        conn.close();
        System.out.println("insert into db");
        // 登陆
        String urlString = "http://localhost:8099/login/toLogin";
        File file = new File("/Users/chengsukai/Desktop/workspace/study/config.txt");
        if (file.exists()) {
            file.delete();
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        randomAccessFile.seek(0);
        for (int i = 0; i < users.size(); i++) {
            TUser user = users.get(i);
            URL url = new URL(urlString);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream out = httpURLConnection.getOutputStream();
            String params = "mobile=" + user.getId() + "&password=" + MD5Util.inputPassword2ServerPass("123456");
            out.write(params.getBytes());
            out.flush();
            InputStream inputStream = httpURLConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buff)) >= 0) {
                byteArrayOutputStream.write(buff, 0, len);
            }
        }

    }

    private static Connection getConn() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/seckill?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "Csk@513434";
        String driver = "com.mysql.cj.jdbc.Driver";
        Class.forName(driver);
        return DriverManager.getConnection(url, username, password);
    }

}
