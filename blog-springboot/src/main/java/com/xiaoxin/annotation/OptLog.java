package com.xiaoxin.annotation;

import java.lang.annotation.*;

/**
 * @author xiaoxin
 * @Description: 操作日志注解
 * @version: $
 * @creat 2021 -10 -01 -19:21
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OptLog {
    /**
     * @return 操作类型
     */
    String optType() default "";
}
