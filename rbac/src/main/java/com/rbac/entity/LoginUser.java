package com.rbac.entity;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
public class LoginUser implements UserDetails {
    private final SysUser user;

    // 存放当前登录用户的权限信息，一个用户可以有多个权限
    private final List<String> permissions;

    public LoginUser(SysUser user, List<String> permissions) {
        this.user = user;
        this.permissions = permissions;
    }

    // 权限集合
    @JsonIgnore
    private List<SimpleGrantedAuthority> authorities;

    @Override

    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (!Objects.isNull(authorities)) {
            return authorities;
        }
        //把permissions中String类型的权限信息封装成SimpleGrantedAuthority
        //第一种方式
//         List<GrantedAuthority> newList = new ArrayList<>();
//        for (String permission : permissions) {
//            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(permission);
//            newList.add(authority);
//        }

        //方式二
        authorities = permissions.stream().
                map(SimpleGrantedAuthority::new).
                collect(Collectors.toList());

        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
