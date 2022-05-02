package com.xiaoxin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoxin.dto.LabelOptionDTO;
import com.xiaoxin.dto.MenuDTO;
import com.xiaoxin.dto.UserMenuDTO;
import com.xiaoxin.entity.Menu;
import com.xiaoxin.vo.ConditionVO;
import com.xiaoxin.vo.MenuVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaoxin
 * @Description:
 * @version: $
 * @creat 2021 -10 -01 -15:26
 */

public interface MenuService extends IService<Menu> {
    /**
     * 查看菜单列表
     *
     * @param conditionVO 条件
     * @return 菜单列表
     */
    List<MenuDTO> listMenus(ConditionVO conditionVO);

    /**
     * 新增或修改菜单
     *
     * @param menuVO 菜单信息
     */
    void saveOrUpdateMenu(MenuVO menuVO);

    /**
     * 删除菜单
     *
     * @param menuId 菜单id
     */
    void deleteMenu(Integer menuId);

    /**
     * 查看角色菜单选项
     *
     * @return 角色菜单选项
     */
    List<LabelOptionDTO> listMenuOptions();

    /**
     * 查看用户菜单
     *
     * @return 菜单列表
     */
    List<UserMenuDTO> listUserMenus();
}
