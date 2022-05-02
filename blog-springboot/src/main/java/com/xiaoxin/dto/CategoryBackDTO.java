package com.xiaoxin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author xiaoxin
 * @Description: 后台分类
 * @version: $
 * @creat 2021 -10 -02 -16:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryBackDTO {

    private Integer id;

    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 文章数量
     */
    private Integer articleCount;

    private LocalDateTime createTime;
}
