package com.xiaoxin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoxin.dto.FriendLinkBackDTO;
import com.xiaoxin.dto.FriendLinkDTO;
import com.xiaoxin.entity.FriendLink;
import com.xiaoxin.vo.ConditionVO;
import com.xiaoxin.vo.FriendLinkVO;
import com.xiaoxin.vo.PageResult;


import java.util.List;

/**
 * 友链服务
 *
 * @author yezhiqiu
 * @date 2021/07/29
 */
public interface FriendLinkService extends IService<FriendLink> {

    /**
     * 查看友链列表
     *
     * @return 友链列表
     */
    List<FriendLinkDTO> listFriendLinks();

    /**
     * 查看后台友链列表
     *
     * @param condition 条件
     * @return 友链列表
     */
    PageResult<FriendLinkBackDTO> listFriendLinkDTO(ConditionVO condition);

    /**
     * 保存或更新友链
     *
     * @param friendLinkVO 友链
     */
    void saveOrUpdateFriendLink(FriendLinkVO friendLinkVO);

}
