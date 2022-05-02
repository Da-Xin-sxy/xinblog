package com.xiaoxin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author xiaoxin
 * @Description: 照片dto
 * @version: $
 * @creat 2021 -10 -02 -13:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhotoDTO {

    /**
     * 相册封面
     */
    private String photoAlbumCover;

    /**
     * 相册名
     */
    private String photoAlbumName;

    /**
     * 照片列表
     */
    private List<String> photoList;

}
