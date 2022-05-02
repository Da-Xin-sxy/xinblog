package com.xiaoxin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoxin.dto.CategoryBackDTO;
import com.xiaoxin.dto.CategoryDTO;
import com.xiaoxin.entity.Category;
import com.xiaoxin.vo.ConditionVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xiaoxin
 * @Description:
 * @version: $
 * @creat 2021 -10 -02 -17:02
 */
@Repository
public interface CategoryDao extends BaseMapper<Category> {

    /**
     * 查询分类和对应文章数量
     * @return 分类列表
     */
    List<CategoryDTO> listCategoryDTO();


    List<CategoryBackDTO> listCategoryBackDTO(@Param("current") Long current, @Param("size") Long size, @Param("condition")ConditionVO conditionVO);
}
