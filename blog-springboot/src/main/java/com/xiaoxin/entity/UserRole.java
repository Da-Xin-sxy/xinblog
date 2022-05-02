package com.xiaoxin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author xiaoxin
 * @Description: 用户角色
 * @version: $
 * @creat 2021 -09 -29 -13:28
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_user_role")
public class UserRole {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    private Integer userId;
    private Integer roleId;

}
