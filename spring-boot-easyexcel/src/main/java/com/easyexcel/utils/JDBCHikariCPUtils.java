package com.easyexcel.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCHikariCPUtils {
    private HikariConfig config;

    private HikariDataSource dataSource;

    public void setConfig(HikariConfig config) {
        this.config = config;
        dataSource = new HikariDataSource(config);
    }

    public void setConfig(Properties properties) {
        config = new HikariConfig();
        config.setDriverClassName(properties.getProperty("driverClassName"));
        config.setUsername(properties.getProperty("username"));
        config.setPassword(properties.getProperty("password"));
        config.setJdbcUrl(properties.getProperty("url"));
        dataSource = new HikariDataSource(config);
    }

    public void setConfig(String path) throws IOException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
        Properties properties = new Properties();
        properties.load(is);
        setConfig(properties);
    }

    public HikariConfig getConfig() {
        return config;
    }

    public HikariDataSource getDataSource() {
        return dataSource;
    }

    public final Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void close(Connection connection, Statement statement) {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
