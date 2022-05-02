package com.xiaoxin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoxin.dto.RoleDTO;
import com.xiaoxin.dto.UserRoleDTO;
import com.xiaoxin.entity.Role;
import com.xiaoxin.vo.ConditionVO;
import com.xiaoxin.vo.PageResult;
import com.xiaoxin.vo.RoleVO;

import java.util.List;

/**
 * @author xiaoxin
 * @Description: 角色服务
 * @version: $
 * @creat 2021 -10 -01 -21:03
 */
public interface RoleService extends IService<Role> {

    /**
     * 获取用户角色选项
     * @return 角色
     */
    List<UserRoleDTO> listUserRoles();

    /**
     * 查询角色列表
     * @param conditionVO 条件
     * @return 角色列表
     */
    PageResult<RoleDTO> listRoles(ConditionVO conditionVO);

    /**
     * 保存或更新角色
     * @param roleVO  角色
     */
    void saveOrUpdateRole(RoleVO roleVO);

    /**
     * 删除角色
     * @param roleIdList 角色id列表
     */
    void deleteRoles(List<Integer> roleIdList);
}
