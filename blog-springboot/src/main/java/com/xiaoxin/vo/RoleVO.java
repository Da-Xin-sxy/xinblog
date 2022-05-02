package com.xiaoxin.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author xiaoxin
 * @Description:
 * @version: $
 * @creat 2021 -10 -01 -21:07
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "角色")
public class RoleVO {

    /**
     * id
     */
    @ApiModelProperty(name = "id", value = "用户id", dataType = "Integer")
    private Integer id;

    /**
     * 角色名
     */
    @NotBlank(message = "角色名不能为空")
    @ApiModelProperty(name = "roleName",value = "角色名",dataType = "String")
    private String roleName;

    /**
     * 标签名
     */
    @ApiModelProperty(name = "categoryName" ,value="标签名",dataType = "String")
    @NotBlank(message = "标签权限不能为空")
    private String RoleLabel;

    /**
     * 资源列表
     */
    @ApiModelProperty(name = "resouceIdList",value = "资源列表",dataType = "List<Integer>")
    private List<Integer> resourceIdList;

    /**
     * 菜单列表
     */
    @ApiModelProperty(name = "menuIdList", value = "菜单列表", required = true, dataType = "List<Integer>")
    private List<Integer> menuIdList;
}
