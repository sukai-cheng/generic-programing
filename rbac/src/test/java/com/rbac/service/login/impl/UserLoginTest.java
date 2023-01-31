//package com.rbac.service.login.impl;
//
//import com.rbac.entity.SysUser;
//import com.rbac.mapper.SysUserMapper;
//import org.junit.Before;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.jupiter.api.Disabled;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//
//@SpringBootTest
//public class UserLoginTest {
//
//    @Autowired
//    private SysUserMapper sysUserMapper;
//
//    @Test
//    public void contextLoads() {
//        System.out.println(sysUserMapper.selectById(1L));
//    }
//
//
//    @Test
//    @Disabled
//    public void isSaveUserSuccessfully(){
////        sysUserMapper.insert(initSysUser());
////        sysUserMapper.batchInsert(List.of(initSysUser()));
//    }
//
//
//    @Test
//    public void isLoginSuccessfully() {
//
//        ArrayList<SysUser> list = new ArrayList<>();
//        for(int i = 0; i < 2; i++){
//            list.add(initSysUser(i));
//        }
//        sysUserMapper.batchInsert(list);
//
//    }
//
//    private SysUser initSysUser(Integer no) {
//        SysUser loginUser = new SysUser();
//        loginUser.setUserName("chengsukai" + no);
//        loginUser.setNickName("chengsukai" + no);
//        loginUser.setEmail("chengsukai@gmail.com");
//        loginUser.setPassword("123456");
//        loginUser.setSex("0");
//        loginUser.setAvatar("www.avatar.com");
//        loginUser.setRemark("Hello , my name is chengsukai");
//        loginUser.setStatus("0");
//        loginUser.setUserType("0");
//        loginUser.setDelFlag("0");
//
//        return loginUser;
//    }
//}
