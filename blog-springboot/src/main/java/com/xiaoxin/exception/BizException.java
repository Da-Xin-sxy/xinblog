package com.xiaoxin.exception;

import com.xiaoxin.enums.StatusCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.xiaoxin.enums.StatusCodeEnum.FAIL;

/**
 * @author xiaoxin
 * @Description: 业务异常
 * @version: $
 * @creat 2021 -09 -30 -17:08
 */
@Getter
@AllArgsConstructor
public class BizException extends RuntimeException{
    /**
     * 错误码
     */
    private Integer code = FAIL.getCode();

    /**
     * 错误信息
     */
    private final String message;

    public BizException(String message) {
        this.message = message;
    }

    public BizException(StatusCodeEnum statusCodeEnum) {
        this.code = statusCodeEnum.getCode();
        this.message = statusCodeEnum.getDesc();
    }
}
