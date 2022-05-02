package com.xiaoxin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoxin.dto.CategoryBackDTO;
import com.xiaoxin.dto.CategoryDTO;
import com.xiaoxin.dto.CategoryOptionDTO;
import com.xiaoxin.entity.Category;
import com.xiaoxin.vo.CategoryVO;
import com.xiaoxin.vo.ConditionVO;
import com.xiaoxin.vo.PageResult;

import java.util.List;

/**
 * @author xiaoxin
 * @Description: 目录、分类
 * @version: $
 * @creat 2021 -10 -02 -17:05
 */
public interface CategoryService extends IService<Category> {
    /**
     * 查询分类列表
     *
     * @return 分类列表
     */
    PageResult<CategoryDTO> listCategories();

    /**
     * 查询后台分类
     *
     * @param conditionVO 条件
     * @return {@link PageResult<CategoryBackDTO>} 后台分类
     */
    PageResult<CategoryBackDTO> listBackCategories(ConditionVO conditionVO);

    /**
     * 搜索文章分类
     *
     * @param condition 条件
     * @return {@link List <CategoryOptionDTO>} 分类列表
     */
    List<CategoryOptionDTO> listCategoriesBySearch(ConditionVO condition);

    /**
     * 删除分类
     *
     * @param categoryIdList 分类id集合
     */
    void deleteCategory(List<Integer> categoryIdList);

    /**
     * 添加或修改分类
     *
     * @param categoryVO 分类
     */
    void saveOrUpdateCategory(CategoryVO categoryVO);
}
