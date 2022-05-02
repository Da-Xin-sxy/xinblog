package com.xiaoxin.handler;

import com.xiaoxin.exception.BizException;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiaoxin
 * @Description: 访问决策管理器
 * @version: $
 * @creat 2021 -10 -01 -9:35
 */
@Component
public class AccessDecisionManagerImpl implements AccessDecisionManager {

    //获取用户权限表
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        System.out.println(LocalDateTime.now()+"走到了校验权限" + authentication.getName());
        List<String> permissionList = authentication.getAuthorities()
               .stream()
               .map(GrantedAuthority::getAuthority)
               .collect(Collectors.toList());
       for (ConfigAttribute item : collection){
           if(permissionList.contains(item.getAttribute())){
               return;
           }
       }
       throw new AccessDeniedException("没有操作权限");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
