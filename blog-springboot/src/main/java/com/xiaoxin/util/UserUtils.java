package com.xiaoxin.util;

import com.xiaoxin.dto.UserDetailDTO;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author xiaoxin
 * @Description: 用户工具类
 * @version: $
 * @creat 2021 -10 -01 -10:08
 */
@Component
public class UserUtils {
    /**
     * 获取当前登录用户
     *
     * @return 用户登录信息
     */
    public static UserDetailDTO getLoginUser() {
        return (UserDetailDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
