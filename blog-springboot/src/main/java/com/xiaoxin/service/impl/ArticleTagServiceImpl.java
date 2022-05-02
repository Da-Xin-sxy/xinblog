package com.xiaoxin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoxin.dao.ArticleTagDao;
import com.xiaoxin.entity.ArticleTag;
import com.xiaoxin.service.ArticleTagService;
import org.springframework.stereotype.Service;

/**
 * 文章标签服务
 *
 * @author yezhiqiu
 * @date 2021/08/10
 */
@Service
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagDao, ArticleTag> implements ArticleTagService {

}
