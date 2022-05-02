package com.xiaoxin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoxin.dto.UserBackDTO;
import com.xiaoxin.entity.UserAuth;
import com.xiaoxin.vo.ConditionVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xiaoxin
 * @Description:
 * @version: $
 * @creat 2021 -09 -30 -18:38
 */
@Repository
public interface UserAuthDao extends BaseMapper<UserAuth> {
    /**
     * 查询后台用户列表
     *
     * @param current   页码
     * @param size      大小
     * @param condition 条件
     * @return {@link List <UserBackDTO>} 用户列表
     */
    List<UserBackDTO> listUsers(@Param("current") Long current, @Param("size") Long size, @Param("condition") ConditionVO condition);

    /**
     * 查询后台用户数量
     *
     * @param condition 条件
     * @return 用户数量
     */
    Integer countUser(@Param("condition") ConditionVO condition);
}
