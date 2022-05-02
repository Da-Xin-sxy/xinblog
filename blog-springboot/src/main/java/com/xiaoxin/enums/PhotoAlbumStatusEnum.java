package com.xiaoxin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xiaoxin
 * @Description: 相册状态枚举
 * @version: $
 * @creat 2021 -10 -02 -13:42
 */
@Getter
@AllArgsConstructor
public enum PhotoAlbumStatusEnum {
    /**
     * 公开
     */
    PUBLIC(1, "公开"),
    /**
     * 私密
     */
    SECRET(2, "私密");

    /**
     * 状态
     */
    private final Integer status;

    /**
     * 描述
     */
    private final String desc;

}
