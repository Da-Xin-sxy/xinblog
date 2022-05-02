package com.xiaoxin.handler;

import com.xiaoxin.dao.RoleDao;
import com.xiaoxin.dto.ResourceRoleDTO;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

/**
 * @author xiaoxin
 * @Description: 接口拦截规则
 * @version: $
 * @creat 2021 -09 -30 -23:29
 */
@Component
public class FilterInvocationSecurityMetadataSourceImpl implements FilterInvocationSecurityMetadataSource {

    /**
     * 资源角色列表
     */
    private static List<ResourceRoleDTO> resourceRoleList;

    @Autowired
    private RoleDao roleDao;

    /**
     * 加载资源角色信息
     */
    // 这里这个顺序要好好再看一下
    @PostConstruct
    private void loadDataSource(){
        resourceRoleList  = roleDao.listResourceRoles();
    }

    /**
     * 清空接口角色信息
     */
    public void clearDataSource(){
        resourceRoleList = null;
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //修改接口角色关系后重新加载
        if(CollectionUtils.isEmpty(resourceRoleList)){
            this.loadDataSource();
        }
        FilterInvocation fi = (FilterInvocation) o;
        // 获取用户请求方式
        String method = fi.getRequest().getMethod();
        // 获取用户请求Url
        String url = fi.getRequest().getRequestURI();
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        // 获取接口角色信息，若为匿名接口则放行，若无对应角色则禁止
        for (ResourceRoleDTO resourceRoleDTO : resourceRoleList) {
            if (antPathMatcher.match(resourceRoleDTO.getUrl(), url) && resourceRoleDTO.getRequestMethod().equals(method)) {
                List<String> roleList = resourceRoleDTO.getRoleList();
                if (CollectionUtils.isEmpty(roleList)) {
                    System.out.println(LocalDateTime.now()+"走到了不是匿名但没有和角色绑定");
                    return SecurityConfig.createList("disable");
                }
                System.out.println(LocalDateTime.now()+"走到了角色权限"+roleList);
                return SecurityConfig.createList(roleList.toArray(new String[]{}));
            }
        }
        System.out.println(LocalDateTime.now()+"走到了匿名获取规则");
        return null;

    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
