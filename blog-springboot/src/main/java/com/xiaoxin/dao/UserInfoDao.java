package com.xiaoxin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoxin.entity.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * @author xiaoxin
 * @Description: 用户信息
 * @version: $
 * @creat 2021 -09 -29 -22:27
 */
@Repository
public interface UserInfoDao extends BaseMapper<UserInfo> {
}
