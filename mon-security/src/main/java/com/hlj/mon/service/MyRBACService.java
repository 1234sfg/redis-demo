package com.hlj.mon.service;


import com.hlj.mon.mo.CustomGrantedAuthority;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

@Component("rabcService")
public class MyRBACService {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 判断某用户是否具有该request资源的访问权限
     */
    public boolean hasPermission(HttpServletRequest request, Authentication authentication){

        Object principal = authentication.getPrincipal();
        boolean hasPermission = false;

            if(principal instanceof UserDetails){

            UserDetails userDetails = (UserDetails)principal;
            //获取访问权限
            List<GrantedAuthority> authorityList =AuthorityUtils.commaSeparatedStringToAuthorityList(request.getRequestURI());
            //获取当前用户拥有的资源
            Collection<CustomGrantedAuthority> authorities =(Collection<CustomGrantedAuthority>) userDetails.getAuthorities();
            String authority=null;
            if (authorityList.size()>0){
                authority = authorityList.get(0).toString();
            }
            for (GrantedAuthority grantedAuthority : authorities) {
                if (antPathMatcher.match(grantedAuthority.getAuthority(), authority)) {
                    hasPermission = true;
                    break;
                }
            }
            return hasPermission;
        }

        return hasPermission;
    }

}
