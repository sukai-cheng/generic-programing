//package com.rbac.config;
//
//import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//import java.util.Objects;
//
//@Configuration
//public class MybatisConfig {
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
//        MybatisSqlSessionFactoryBean sessionFactoryBean = new MybatisSqlSessionFactoryBean();
//        sessionFactoryBean.setDataSource(dataSource);
//        return Objects.requireNonNull(sessionFactoryBean.getObject());
//    }
//}
