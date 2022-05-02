package com.xiaoxin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaoxin
 * @Description: 后台照片
 * @version: $
 * @creat 2021 -10 -02 -13:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhotoBackDTO {
    /**
     * 照片id
     */
    private Integer id;

    /**
     * 照片名
     */
    private String photoName;

    /**
     * 照片描述
     */
    private String photoDesc;

    /**
     * 照片地址
     */
    private String photoSrc;
}
