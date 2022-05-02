package com.xiaoxin.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoxin.dao.UserInfoDao;
import com.xiaoxin.dto.UserDetailDTO;
import com.xiaoxin.entity.UserInfo;
import com.xiaoxin.entity.UserRole;
import com.xiaoxin.enums.FilePathEnum;
import com.xiaoxin.exception.BizException;
import com.xiaoxin.service.RedisService;
import com.xiaoxin.service.UserInfoService;
import com.xiaoxin.service.UserRoleService;
import com.xiaoxin.strategy.context.UploadStrategyContext;
import com.xiaoxin.util.UserUtils;
import com.xiaoxin.vo.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.xiaoxin.constant.RedisPrefixConst.USER_CODE_KEY;
import static com.xiaoxin.util.PageUtils.getLimitCurrent;
import static com.xiaoxin.util.PageUtils.*;

/**
 * @author xiaoxin
 * @Description:
 * @version: $
 * @creat 2021 -09 -29 -22:45
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfo> implements UserInfoService {


    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private SessionRegistry sessionRegistry;
    @Autowired
    private UploadStrategyContext uploadStrategyContext;
    @Autowired
    private RedisService redisService;
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateUserInfo(UserInfoVO userInfoVO) {
        //封装用户信息
        UserInfo userInfo = UserInfo.builder()
                .id(UserUtils.getLoginUser().getUserInfoId())
                .nickname(userInfoVO.getNickname())
                .intro(userInfoVO.getIntro())
                .webSite(userInfoVO.getWebSite())
                .build();
        userInfoDao.updateById(userInfo);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String updateUserAvatar(MultipartFile file) {
        //头像上传
        String avatar = uploadStrategyContext.executeUploadStrategy(file, FilePathEnum.AVATAR.getPath());
        //更新用户信息
        UserInfo userInfo = UserInfo.builder()
                .id(UserUtils.getLoginUser().getUserInfoId())
                .avatar(avatar)
                .build();
        userInfoDao.updateById(userInfo);
        return avatar;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveUserEmail(EmailVO emailVO) {
        if (!emailVO.getCode().equals(redisService.get(USER_CODE_KEY + emailVO.getEmail()).toString())) {
            throw new BizException("验证码错误！");
        }
        UserInfo userInfo = UserInfo.builder()
                .id(UserUtils.getLoginUser().getUserInfoId())
                .email(emailVO.getEmail())
                .build();
        userInfoDao.updateById(userInfo);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateUserRole(UserRoleVO userRoleVO) {
        //更新用户角色和昵称
        UserInfo userInfo = UserInfo.builder()
                .id(userRoleVO.getUserInfoId())
                .nickname(userRoleVO.getNickname())
                .build();
        userInfoDao.updateById(userInfo);
        //删除用户角色重新添加
        userRoleService.remove(new LambdaQueryWrapper<UserRole>()
        .eq(UserRole::getUserId,userRoleVO.getUserInfoId()));
        List<UserRole> userRoleList = userRoleVO.getRoleIdList().stream()
                .map(roleId -> UserRole.builder()
                .roleId(roleId)
                .userId(userRoleVO.getUserInfoId())
                .build())
                .collect(Collectors.toList());
        userRoleService.saveBatch(userRoleList);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateUserDisable(UserDisableVO userDisableVo) {
        // 更新用户禁用状态
        UserInfo userInfo = UserInfo.builder()
                .id(userDisableVo.getId())
                .isDisable(userDisableVo.getIsDisable())
                .build();
        userInfoDao.updateById(userInfo);
    }

    @Override
    public PageResult<UserOnlineDTO> listOnlineUsers(ConditionVO conditionVO) {
        // 获取security在线session
        List<UserOnlineDTO> userOnlineDTOList = sessionRegistry.getAllPrincipals().stream()
                .filter(item -> sessionRegistry.getAllSessions(item, false).size() > 0)
                .map(item -> JSON.parseObject(JSON.toJSONString(item), UserOnlineDTO.class))
                .filter(item -> StringUtils.isBlank(conditionVO.getKeywords()) || item.getNickname().contains(conditionVO.getKeywords()))
                .sorted(Comparator.comparing(UserOnlineDTO::getLastLoginTime).reversed())
                .collect(Collectors.toList());
        // 执行分页
        int fromIndex = getLimitCurrent().intValue();
        int size = getSize().intValue();
        int toIndex = userOnlineDTOList.size() - fromIndex > size ? fromIndex + size : userOnlineDTOList.size();
        List<UserOnlineDTO> userOnlineList = userOnlineDTOList.subList(fromIndex, toIndex);
        return new PageResult<>(userOnlineList,userOnlineDTOList.size());
    }

    @Override
    public void removeOnlineUser(Integer userInfoId) {
        // 获取用户session
        List<Object> userInfoList = sessionRegistry.getAllPrincipals().stream().filter(item -> {
            UserDetailDTO userDetailDTO = (UserDetailDTO) item;
            return userDetailDTO.getUserInfoId().equals(userInfoId);
        }).collect(Collectors.toList());
        List<SessionInformation> allSessions = new ArrayList<>();
        userInfoList.forEach(item -> allSessions.addAll(sessionRegistry.getAllSessions(item, false)));
        // 注销session
        allSessions.forEach(SessionInformation::expireNow);
    }




}
