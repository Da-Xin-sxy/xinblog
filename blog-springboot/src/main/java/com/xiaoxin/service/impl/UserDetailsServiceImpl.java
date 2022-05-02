package com.xiaoxin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.xiaoxin.dao.RoleDao;
import com.xiaoxin.dao.UserAuthDao;
import com.xiaoxin.dao.UserInfoDao;
import com.xiaoxin.dto.UserDetailDTO;
import com.xiaoxin.entity.UserAuth;
import com.xiaoxin.entity.UserInfo;
import com.xiaoxin.exception.BizException;
import com.xiaoxin.service.RedisService;
import com.xiaoxin.util.IpUtils;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static com.xiaoxin.constant.RedisPrefixConst.ARTICLE_USER_LIKE;
import static com.xiaoxin.constant.RedisPrefixConst.COMMENT_USER_LIKE;
import static com.xiaoxin.enums.ZoneEnum.SHANGHAI;

/**
 * @author xiaoxin
 * @Description: 用户详细信息获取以及封装
 * @version: $
 * @creat 2021 -09 -30 -21:41
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserAuthDao userAuthDao;
    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private RoleDao roleDao;
    @Resource
    private HttpServletRequest request;
    @Autowired
    private RedisService redisService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isBlank(username)){
            throw new BizException("用户名为空");
        }
        //查询账号是否存在
        UserAuth userAuth = userAuthDao.selectOne(new LambdaQueryWrapper<UserAuth>()
                .select(UserAuth::getId, UserAuth::getUserInfoId, UserAuth::getUsername, UserAuth::getPassword, UserAuth::getLoginType)
                .eq(UserAuth::getUsername, username));
        System.out.println(LocalDateTime.now()+"走到了用户登录");
        if(Objects.isNull(userAuth)){
            throw new BizException("用户名不存在");
        }
        //封装登录信息
        return convertUserDetail(userAuth,request);
    }

    /**
     * 封装用户登录信息
     *
     * @param user    用户账号
     * @param request 请求
     * @return 用户登录信息
     */
    public UserDetailDTO convertUserDetail(UserAuth user, HttpServletRequest request){
        //查询账号信息
        UserInfo userInfo = userInfoDao.selectById(user.getUserInfoId());
        //查询账号角色
        List<String> roleList = roleDao.listRolesByUserInfoId(userInfo.getId());
        //查询账号点赞信息
        // 查询账号点赞信息
        Set<Object> articleLikeSet = redisService.sMembers(ARTICLE_USER_LIKE + userInfo.getId());
        Set<Object> commentLikeSet = redisService.sMembers(COMMENT_USER_LIKE + userInfo.getId());
        //获取设备信息
        String ipAddress = IpUtils.getIpAddress(request);
        String ipSource = IpUtils.getIpSource(ipAddress);
        UserAgent userAgent = IpUtils.getUserAgent(request);
        //封装权限集合
        return UserDetailDTO.builder()
                .id(user.getId())
                .userInfoId(user.getUserInfoId())
                .loginType(user.getLoginType())
                .username(user.getUsername())
                .password(user.getPassword())
                .email(userInfo.getEmail())
                .roleList(roleList)
                .nickname(userInfo.getNickname())
                .avatar(userInfo.getAvatar())
                .webSite(userInfo.getWebSite())
                .intro(userInfo.getIntro())
                .articleLikeSet(articleLikeSet)
                .commentLikeSet(commentLikeSet)
                .ipAddress(ipAddress)
                .ipSource(ipSource)
                .isDisable(userInfo.getIsDisable())
                .browser(userAgent.getBrowser().getName())
                .os(userAgent.getOperatingSystem().getName())
                .lastLoginTime(LocalDateTime.now(ZoneId.of(SHANGHAI.getZone())))
                .build();
    }




}
