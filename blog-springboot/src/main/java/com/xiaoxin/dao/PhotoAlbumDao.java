package com.xiaoxin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoxin.dto.PhotoAlbumBackDTO;
import com.xiaoxin.entity.PhotoAlbum;
import com.xiaoxin.vo.ConditionVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xiaoxin
 * @Description:
 * @version: $
 * @creat 2021 -10 -02 -13:05
 */
@Repository
public interface PhotoAlbumDao extends BaseMapper<PhotoAlbum> {


    /**
     * 查询后台相册列表
     * @param current 页码
     * @param size 大小
     * @param conditionVO 条件
     * @return 相册列表
     */
    List<PhotoAlbumBackDTO> listPhotoAlbumBacks(@Param("current") Long current, @Param("size") Long size, @Param("condition") ConditionVO conditionVO);
}
