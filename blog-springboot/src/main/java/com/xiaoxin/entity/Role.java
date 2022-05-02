package com.xiaoxin.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author xiaoxin
 * @Description: 角色类型
 * @version: $
 * @creat 2021 -09 -29 -13:45
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_role")
public class Role {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //角色名
    private String roleName;
    //角色标签
    private String roleLabel;
    //是否禁用
    private Integer isDisable;


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
