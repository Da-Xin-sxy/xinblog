package com.xiaoxin.controller;

import com.xiaoxin.annotation.OptLog;
import com.xiaoxin.dto.BlogBackInfoDTO;
import com.xiaoxin.dto.BlogHomeInfoDTO;
import com.xiaoxin.enums.FilePathEnum;
import com.xiaoxin.service.BlogInfoService;
import com.xiaoxin.strategy.context.UploadStrategyContext;
import com.xiaoxin.vo.BlogInfoVO;
import com.xiaoxin.vo.Result;
import com.xiaoxin.vo.WebsiteConfigVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

import static com.xiaoxin.constant.OptTypeConst.UPDATE;

/**
 * @author xiaoxin
 * @Description:
 * @version: $
 * @creat 2021 -10 -02 -15:46
 */
@Api(tags = "博客信息模块")
@RestController
public class BlogInfoController {
    @Autowired
    private BlogInfoService blogInfoService;
//    @Autowired
//    private WebSocketServiceImpl webSocketService;
    @Autowired
    private UploadStrategyContext uploadStrategyContext;

    /**
     * 查看博客信息
     *
     * @return {@link Result<BlogHomeInfoDTO>} 博客信息
     */
    @ApiOperation(value = "查看博客信息")
    @GetMapping("/")
    public Result<BlogHomeInfoDTO> getBlogHomeInfo() {
        /**
         * 这里用来测试，是否可以从securityContext中拿到ip地址等信息
         */
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();
//        System.out.println("测试ip，session"+details);
        return Result.ok(blogInfoService.getBlogHomeInfo());
    }

    /**
     * 查看后台信息
     *
     * @return {@link Result<BlogBackInfoDTO>} 后台信息
     */
    @ApiOperation(value = "查看后台信息")
    @GetMapping("/admin")
    public Result<BlogBackInfoDTO> getBlogBackInfo() {
        return Result.ok(blogInfoService.getBlogBackInfo());
    }

    /**
     * 上传博客配置图片
     *
     * @param file 文件
     * @return {@link Result<String>} 博客配置图片
     */
    @ApiOperation(value = "上传博客配置图片")
    @ApiImplicitParam(name = "file", value = "图片", required = true, dataType = "MultipartFile")
    @PostMapping("/admin/config/images")
    public Result<String> savePhotoAlbumCover(MultipartFile file) {
        return Result.ok(uploadStrategyContext.executeUploadStrategy(file, FilePathEnum.CONFIG.getPath()));
    }

    /**
     * 更新网站配置
     *
     * @param websiteConfigVO 网站配置信息
     * @return {@link Result}
     */
    @ApiOperation(value = "更新网站配置")
    @PutMapping("/admin/website/config")
    public Result<?> updateWebsiteConfig(@Valid @RequestBody WebsiteConfigVO websiteConfigVO) {
        blogInfoService.updateWebsiteConfig(websiteConfigVO);
        return Result.ok();
    }

    /**
     * 获取网站配置
     *
     * @return {@link Result<WebsiteConfigVO>} 网站配置
     */
    @ApiOperation(value = "获取网站配置")
    @GetMapping("/admin/website/config")
    public Result<WebsiteConfigVO> getWebsiteConfig() {
        return Result.ok(blogInfoService.getWebsiteConfig());
    }

    /**
     * 查看关于我信息
     *
     * @return {@link Result<String>} 关于我信息
     */
    @ApiOperation(value = "查看关于我信息")
    @GetMapping("/about")
    public Result<String> getAbout() {
        return Result.ok(blogInfoService.getAbout());
    }

    /**
     * 修改关于我信息
     *
     * @param blogInfoVO 博客信息
     * @return {@link Result<>}
     */
    @OptLog(optType = UPDATE)
    @ApiOperation(value = "修改关于我信息")
    @PutMapping("/admin/about")
    public Result<?> updateAbout(@Valid @RequestBody BlogInfoVO blogInfoVO) {
        blogInfoService.updateAbout(blogInfoVO);
        return Result.ok();
    }

    /**
     * 保存语音信息
     *
     * @param voiceVO 语音信息
     * @return {@link Result<String>} 语音地址
     */
//    @ApiOperation(value = "上传语音")
//    @PostMapping("/voice")
//    public Result<String> sendVoice(VoiceVO voiceVO) {
//        webSocketService.sendVoice(voiceVO);
//        return Result.ok();
//    }

    /**
     * 上传访客信息
     *
     * @return {@link Result}
     */
    @PostMapping("/report")
    public Result<?> report() {
        blogInfoService.report();
        return Result.ok();
    }

}
