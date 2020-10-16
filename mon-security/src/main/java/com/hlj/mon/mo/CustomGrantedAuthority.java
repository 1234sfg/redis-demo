package com.hlj.mon.mo;

import org.springframework.security.core.GrantedAuthority;


/**
 * 自定义CustomGrantedAuthority权限类，如果直接使用GrantedAuthority，会默认实现SimpleGrantedAuthority，此类无法反序列化，导致缓存读取失败
 */
public class CustomGrantedAuthority implements GrantedAuthority {

    String authority;

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority){
        this.authority=authority;
    }
}
