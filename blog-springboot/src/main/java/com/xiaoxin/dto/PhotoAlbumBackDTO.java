package com.xiaoxin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaoxin
 * @Description:
 * @version: $
 * @creat 2021 -10 -02 -13:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhotoAlbumBackDTO {
    /**
     * 相册id
     */
    private Integer id;

    /**
     * 相册名
     */
    private String albumName;

    /**
     * 相册描述
     */
    private String albumDesc;

    /**
     * 相册封面
     */
    private String albumCover;

    /**
     * 照片数量
     */
    private Integer photoCount;

    /**
     * 状态值 1公开 2私密
     */
    private Integer status;
}
