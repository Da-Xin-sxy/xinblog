package com.xiaoxin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoxin.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xiaoxin
 * @Description:
 * @version: $
 * @creat 2021 -10 -01 -15:28
 */
@Repository
public interface MenuDao extends BaseMapper<Menu> {
    /**
     * 根据用户id查询菜单
     * @param userInfoId 用户信息id
     * @return 菜单列表
     */
    List<Menu> listMenusByUserInfoId(Integer userInfoId);
}
