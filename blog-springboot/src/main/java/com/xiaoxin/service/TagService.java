package com.xiaoxin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoxin.dto.TagBackDTO;
import com.xiaoxin.dto.TagDTO;
import com.xiaoxin.entity.Tag;
import com.xiaoxin.vo.ConditionVO;
import com.xiaoxin.vo.PageResult;
import com.xiaoxin.vo.TagVO;

import java.util.List;

/**
 * @author xiaoxin
 * @Description:
 * @version: $
 * @creat 2021 -10 -02 -17:17
 */
public interface TagService extends IService<Tag> {
    /**
     * 查询标签列表
     *
     * @return 标签列表
     */
    PageResult<TagDTO> listTags();

    /**
     * 查询后台标签
     *
     * @param condition 条件
     * @return {@link PageResult<TagBackDTO>} 标签列表
     */
    PageResult<TagBackDTO> listTagBackDTO(ConditionVO condition);

    /**
     * 搜索文章标签
     *
     * @param condition 条件
     * @return {@link List <TagDTO>} 标签列表
     */
    List<TagDTO> listTagsBySearch(ConditionVO condition);

    /**
     * 删除标签
     *
     * @param tagIdList 标签id集合
     */
    void deleteTag(List<Integer> tagIdList);

    /**
     * 保存或更新标签
     *
     * @param tagVO 标签
     */
    void saveOrUpdateTag(TagVO tagVO);
}
