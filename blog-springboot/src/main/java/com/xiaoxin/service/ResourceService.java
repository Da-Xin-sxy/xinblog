package com.xiaoxin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoxin.dto.LabelOptionDTO;
import com.xiaoxin.dto.ResourceDTO;
import com.xiaoxin.entity.Resource;
import com.xiaoxin.vo.ConditionVO;
import com.xiaoxin.vo.ResourceVO;

import java.util.List;

/**
 * @author xiaoxin
 * @Description: 资源服务
 * @version: $
 * @creat 2021 -10 -02 -11:09
 */
public interface ResourceService extends IService<Resource> {

    /**
     * 导入Swagger权限
     */
    void importSwagger();

    /**
     * 添加或修改资源
     * @param resourceVO
     */
    void saveOrUpdateResource(ResourceVO resourceVO);

    /**
     * 删除资源
     * @param resourceId 资源Id
     */
    void deleteResource(Integer resourceId);

    /**
     * 查看资源列表
     * @param conditionVO 条件
     * @return
     */
    List<ResourceDTO> listResources(ConditionVO conditionVO);


    /**
     * 查看资源选项
     * @return
     */
    List<LabelOptionDTO> listResourceOption();
}
