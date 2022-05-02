package com.xiaoxin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaoxin
 * @Description:
 * @version: $
 * @creat 2021 -10 -02 -17:13
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TagDTO {
    /**
     * id
     */
    private Integer id;

    /**
     * 标签名
     */
    private String tagName;

}
