package com.xiaoxin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author xiaoxin
 * @Description: 后台标签
 * @version: $
 * @creat 2021 -10 -02 -17:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TagBackDTO {
    /**
     * 标签id
     */
    private Integer id;

    /**
     * 标签名
     */
    private String tagName;

    /**
     * 文章量
     */
    private Integer articleCount;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
