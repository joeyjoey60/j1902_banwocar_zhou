package com.joey.demo.config;

import com.joey.demo.shiro.MyRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhou on 2019/7/11.
 */
@Configuration
public class ShiroConfig {
    //    创建自定义的realm对象
    @Bean(name="myRealm")
    public MyRealm getRealm(HashedCredentialsMatcher credentialsMatcher){

        MyRealm myRealm=new MyRealm();
        myRealm.setCredentialsMatcher(credentialsMatcher);
        return myRealm;
    }
    //    创建安全管理器
    @Bean(name="defaultWebSecurityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("myRealm") MyRealm myRealm){
//       创建secuManager对象
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        设置自定义的realm
        securityManager.setRealm(myRealm);
        return securityManager;
    }

    //    创建shiro权限过滤器
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager")DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);
        filterFactoryBean.setUnauthorizedUrl("/unauth");//无权访问时显示的页面
        Map<String ,String> map = new HashMap<>();
        map.put("/main","authc");//只有登录后才可访问
        filterFactoryBean.setFilterChainDefinitionMap(map);//设置拦截权限
        return filterFactoryBean;
    }

    //开启注解验证模式
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator=new DefaultAdvisorAutoProxyCreator();
        return  advisorAutoProxyCreator;

    }
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("defaultWebSecurityManager")DefaultWebSecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor sourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        sourceAdvisor.setSecurityManager(securityManager);

        return  sourceAdvisor;
    }
    //添加凭证匹配器
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        //创建凭证匹配器
        HashedCredentialsMatcher credentialsMatcher=new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");//算法名称 还可以SSH1
        credentialsMatcher.setHashIterations(1024);//加密次数
        credentialsMatcher.setStoredCredentialsHexEncoded(true);//编码后的暂存为16进制字符串
        return  credentialsMatcher;

    }
}
