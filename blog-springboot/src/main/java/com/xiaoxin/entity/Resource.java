package com.xiaoxin.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.sun.mail.imap.Rights;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author xiaoxin
 * @Description: 资源
 * @version: $
 * @creat 2021 -09 -29 -13:55
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_resource")
public class Resource {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    // 权限名
    private String resourceName;

    //权限路径
    private String url;

    //请求方式
    private String requestMethod;

    //父权限Id
    private Integer parentId;

    //是否匿名访问
    private Integer isAnonymous;

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
