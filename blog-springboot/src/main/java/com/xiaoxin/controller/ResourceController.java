package com.xiaoxin.controller;

import com.xiaoxin.dto.LabelOptionDTO;
import com.xiaoxin.dto.ResourceDTO;
import com.xiaoxin.service.ResourceService;
import com.xiaoxin.vo.ConditionVO;
import com.xiaoxin.vo.ResourceVO;
import com.xiaoxin.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author xiaoxin
 * @Description: 资源控制器
 * @version: $
 * @creat 2021 -10 -02 -11:07
 */
@Api(tags = "资源模块")
@RestController
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @ApiOperation(value = "导入swagger接口")
    @GetMapping("/admin/resources/import/swagger")
    public Result<?> importSwagger() {
        resourceService.importSwagger();
        return Result.ok();
    }

    /**
     * 查看资源列表
     * @param conditionVO
     * @return
     */
    @ApiOperation(value = "查看资源列表")
    @GetMapping("/admin/resources")
    public Result<List<ResourceDTO>> listResources(ConditionVO conditionVO){
        return Result.ok(resourceService.listResources(conditionVO));
    }

    /**
     * 删除资源
     * @param resourceId 资源id
     * @return
     */
    @ApiOperation(value = "删除资源")
    @DeleteMapping("/admin/resources/{resourceId}")
    public Result<?> deleteResource(@PathVariable("resourceId") Integer resourceId){
        resourceService.deleteResource(resourceId);
        return Result.ok();
    }

    /**
     * 新增或修改资源
     * @param resourceVO 资源信息
     * @return
     */
    @ApiOperation(value = "新增或修改资源")
    @PostMapping("/admin/resources")
    public Result<?> saveOrUpdateResource(@Valid @RequestBody ResourceVO resourceVO){
        resourceService.saveOrUpdateResource(resourceVO);
        return Result.ok();
    }

    /**
     * 查看角色资源选项
     * @return
     */
    @ApiOperation(value = "查看角色资源选项")
    @GetMapping("/admin/role/resources")
    public Result<List<LabelOptionDTO>> listResourceOption(){
        return Result.ok(resourceService.listResourceOption());
    }
}
