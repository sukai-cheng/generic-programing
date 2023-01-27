package com.rbac.service.login.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rbac.entity.LoginUser;
import com.rbac.entity.SysUser;
import com.rbac.mapper.SysUserMapper;
import com.rbac.service.login.UserDetailsService;
import com.rbac.utils.CodeEnum;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private SysUserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getUserName, username);
        SysUser user = userMapper.selectOne(queryWrapper);

        if (Objects.isNull(user)) {
            throw new RuntimeException(CodeEnum.USERNAME_OR_PASSWORD_FAILURE.getMsg());
        }

        List<String> list = new ArrayList<>(List.of("hello"));

        return new LoginUser(user, list);
    }
}
