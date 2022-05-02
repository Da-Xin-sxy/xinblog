package com.xiaoxin.handler;

import com.xiaoxin.exception.BizException;
import com.xiaoxin.vo.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sun.misc.Version;

import java.util.Objects;

import static com.xiaoxin.enums.StatusCodeEnum.SYSTEM_ERROR;
import static com.xiaoxin.enums.StatusCodeEnum.VALID_ERROR;

/**
 * @author xiaoxin
 * @Description: 全局异常处理
 * @version: $
 * @creat 2021 -09 -30 -17:02
 */
@Log4j2
@RestControllerAdvice
public class ControllerAdviceHandler {

    /**
     * 处理服务异常
     *
     * @param e 异常
     * @return 接口异常信息
     */
    @ExceptionHandler(value = BizException.class)
    public Result<?> errorHandler(BizException e){
        return Result.fail(e.getCode(),e.getMessage());
    }

    /**
     * 处理参数校验异常
     *
     * @param e 异常
     * @return 接口异常信息
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<?> errorHandler(MethodArgumentNotValidException e){
        return Result.fail(VALID_ERROR.getCode(), Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }

    /**
     * 处理系统异常
     *
     * @param e 异常
     * @return 接口异常信息
     */
    @ExceptionHandler(value = Exception.class)
    public Result<?> errorHandler(Exception e){
        e.printStackTrace();
        return Result.fail(SYSTEM_ERROR.getCode(),SYSTEM_ERROR.getDesc());
    }
}
