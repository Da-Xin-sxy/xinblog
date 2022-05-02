package com.xiaoxin.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author xiaoxin
 * @Description: 菜单
 * @version: $
 * @creat 2021 -09 -29 -14:13
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_menu")
public class Menu {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;
    //路径
    private String path;
    //组件
    private String component;
    //图表
    private String icon;
    //排序
    private Integer orderNum;
    // 父Id
    private Integer parentId;
    // 是否隐藏
    private Integer isHidden;

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
