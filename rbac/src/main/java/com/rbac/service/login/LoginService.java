package com.rbac.service.login;

import com.rbac.entity.SysUser;
import com.rbac.utils.ResponseResult;

public interface LoginService {

    ResponseResult<?> login(SysUser user);

    ResponseResult<?> logout();
}
