package com.xiaoxin.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author xiaoxin
 * @Description: 用户信息
 * @version: $
 * @creat 2021 -09 -29 -13:29
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_user_info")
public class UserInfo {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    private String email;
    private String nickname;
    // 用户头像
    private String avatar;
    // 用户简介
    private String intro;
    private String webSite;
    // 用户是否被禁言
    private Integer isDisable;


    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;


    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;



}
