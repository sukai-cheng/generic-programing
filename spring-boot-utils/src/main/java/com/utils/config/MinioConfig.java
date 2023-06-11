package com.utils.config;

import io.minio.MinioClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chengsukai
 * @since 2023-06-10 09:54
 */
@Configuration
@Data
public class MinioConfig {
    @Value("${minio.ip}")
    private String ip;
    @Value("${minio.username}")
    private String username;
    @Value("${minio.password}")
    private String password;

    /**
     * 初始化连接信息
     */
    @Bean
    public MinioClient minioClient(){
        return MinioClient.builder().endpoint(ip)
                .credentials(username, password)
                .build();
    }
}
