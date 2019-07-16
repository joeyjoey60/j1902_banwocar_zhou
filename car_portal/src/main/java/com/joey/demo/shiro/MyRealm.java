package com.joey.demo.shiro;

import com.joey.demo.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import pojo.AdminPermission;
import pojo.AdminUser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhou on 2019/7/10.
 */
public class MyRealm extends AuthorizingRealm {


    @Autowired
    private UserService userService;
    @Override

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("eeeeeeeeeeeeeeeee");
        Object principal = principalCollection.getPrimaryPrincipal();
        String usename=(String)principal;
        System.out.println("eeeeeeeeeeeeeeeee");
        List<AdminPermission> permissions =userService.findPermissionByLoginName(usename);
        Set<String> lists=new HashSet<>();
         System.out.println(permissions+"BBBBBBBBBBBBBBBBB");
        if(permissions!=null){
            for(AdminPermission p:permissions){
                lists.add(p.getPerName());
            }
        }
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        authorizationInfo.setStringPermissions(lists);

        return authorizationInfo;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户名
        String principal = (String)authenticationToken.getPrincipal();
        //获取用户信息
        AdminUser userByLoginName = userService.findUserByLoginName(principal);
        SimpleAuthenticationInfo authenticationInfo = null;
         System.out.println(principal+"rrrrrrrrrrrrrrrrrrrrrrrrr");

        if(userByLoginName!=null){
            authenticationInfo=new SimpleAuthenticationInfo(principal,userByLoginName.getPassword(),null,this.getName());
        }

        return authenticationInfo;
    }
}
