package com.xiaoxin.enums;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.security.PrivateKey;

/**
 * @author xiaoxin
 * @Description:
 * @version: $
 * @creat 2021 -09 -30 -16:37
 */
@Getter
@AllArgsConstructor
public enum StatusCodeEnum {
    SUCCESS(20000,"操作成功"),
    /**
     * 系统异常
     */
    SYSTEM_ERROR(50000, "系统异常"),
    /**
     * 参数校验失败
     */
    VALID_ERROR(52000, "参数格式不正确"),
    /**
     * 没有操作权限
     */
    AUTHORIZED(40300, "没有操作权限"),
    /**
     * 用户名已存在
     */
    USERNAME_EXIST(52001, "用户名已存在"),
    /**
     * 用户名不存在
     */
    USERNAME_NOT_EXIST(52002, "用户名不存在"),
    /**
     * qq登录错误
     */
    QQ_LOGIN_ERROR(53001, "qq登录错误"),
    /**
     * 微博登录错误
     */
    WEIBO_LOGIN_ERROR(53002, "微博登录错误"),
    FAIL(51000,"操作失败");

    private final Integer code;
    private final String desc;
}
