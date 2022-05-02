package com.xiaoxin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaoxin
 * @Description: 分类选项
 * @version: $
 * @creat 2021 -10 -02 -16:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryOptionDTO {


    /**
     * 分类id
     */
    private Integer id;

    /**
     * 分类名
     */
    private String categoryName;
}
