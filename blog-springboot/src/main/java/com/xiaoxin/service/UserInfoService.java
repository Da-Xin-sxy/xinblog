package com.xiaoxin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoxin.entity.UserInfo;
import com.xiaoxin.vo.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author xiaoxin
 * @Description:
 * @version: $
 * @creat 2021 -09 -29 -22:30
 */
public interface UserInfoService extends IService<UserInfo> {




    /**
     * 修改用户资料
     */
    void updateUserInfo(UserInfoVO userInfoVO);

    /**
     *
     * @param file 头像图片
     * @return 头像地址
     */
    String updateUserAvatar(MultipartFile file);

    /**
     * 绑定用户邮箱
     * @param emailVO 邮箱
     */
    void saveUserEmail(EmailVO emailVO);

    /**
     *  更新用户角色
     * @param userRoleVO 更新用户角色
     */
    void updateUserRole(UserRoleVO userRoleVO);

    /**
     *  修改用户禁用状态
     * @param userDisableVo 用户禁用信息
     */
   void updateUserDisable(UserDisableVO userDisableVo);

    /**
     * 查看在线用户列表
     * @param conditionVO 条件
     * @return 在线用户列表
     */
   PageResult<UserOnlineDTO> listOnlineUsers(ConditionVO conditionVO);

    /**
     * 下线用户
     * @param userInfoId 用户信息id
     */
   void removeOnlineUser(Integer userInfoId);

}
