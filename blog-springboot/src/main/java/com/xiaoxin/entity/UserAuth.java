package com.xiaoxin.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.swing.plaf.ProgressBarUI;
import java.time.LocalDateTime;

/**
 * @author xiaoxin
 * @Description: 用户账号
 * @version: $
 * @creat 2021 -09 -29 -13:35
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_user_auth")
public class UserAuth {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户信息id
     */
    private Integer userInfoId;

    private String username;
    private String password;

    //登录类型
    private Integer loginType;

    private String ipAddress;

    private String ipSource;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;


    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    /**
     * 最近登录时间
     */
    private LocalDateTime lastLoginTime;
}
