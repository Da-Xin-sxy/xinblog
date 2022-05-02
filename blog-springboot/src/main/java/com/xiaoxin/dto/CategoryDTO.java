package com.xiaoxin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaoxin
 * @Description: 分类
 * @version: $
 * @creat 2021 -10 -02 -16:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDTO {

    private Integer id;

    private String categoryName;

    /**
     * 分类下的文章数量
     */
    private Integer articleCount;
}
