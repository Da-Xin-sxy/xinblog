package com.xiaoxin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaoxin
 * @Description: 角色菜单
 * @version: $
 * @creat 2021 -09 -29 -14:21
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_role_menu")
public class RoleMenu {

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 菜单id
     */
    private Integer menuId;
}
