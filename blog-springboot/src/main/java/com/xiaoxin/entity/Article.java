package com.xiaoxin.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author xiaoxin
 * @Description: 文章
 * @version: $
 * @creat 2021 -09 -29 -14:37
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_article")
public class Article {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    // 作者
    private Integer userId;
    // 文章分类
    private Integer categoryId;
    // 文章缩略图
    private String articleCover;
    // 标题
    private String articleTitle;
    // 内容
    private String articleContent;
    // 文章类型
    private Integer type;
    // 原文链接
    private String originalUrl;
    // 是否置顶
    private Integer isTop;
    // 是否删除
    private Integer isDelete;
    // 文章状态 1.公开 2.私密 3.评论可见
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
}
