package com.xiaoxin.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author xiaoxin
 * @Description: 用户禁用状态
 * @version: $
 * @creat 2021 -10 -01 -17:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "用户禁用状态")
public class UserDisableVO {

    @NotNull(message = "用户id不能为空")
    private Integer id;

    /**
     * 禁用状态
     */
    @NotNull(message = "禁用状态不能为空")
    private Integer isDisable;
}
