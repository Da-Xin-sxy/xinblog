package com.xiaoxin.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author xiaoxin
 * @Description: 资源
 * @version: $
 * @creat 2021 -10 -02 -11:11
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "资源")
public class ResourceVO {

    @ApiModelProperty(name = "id",value = "资源id", dataType = "Integer")
    private Integer id;

    @NotBlank(message = "资源名不能为空")
    @ApiModelProperty(name = "resourceName",value = "资源名",dataType = "String")
    private String resourceName;

    @ApiModelProperty(name = "url",value = "资源路径",dataType = "String")
    private String url;

    @ApiModelProperty(name = "requestMethod",value = "请求方式",dataType = "String")
    private String requestMethod;

    @ApiModelProperty(name = "parentId",value = "父资源Id",dataType = "Integer")
    private Integer parentId;

    @ApiModelProperty(name = "isAnonymous", value = "是否匿名访问", required = true, dataType = "Integer")
    private Integer isAnonymous;
}
