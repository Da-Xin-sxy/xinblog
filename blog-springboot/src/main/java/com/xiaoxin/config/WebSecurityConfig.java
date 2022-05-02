package com.xiaoxin.config;

import com.xiaoxin.handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import java.time.LocalDateTime;

/**
 * @author xiaoxin
 * @Description: Security配置类
 * @version: $
 * @creat 2021 -09 -30 -18:31
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationEntryPointImpl authenticationEntryPoint; //未登录
    @Autowired
    private AccessDeniedHandlerImpl accessDeniedHandler; //无权访问
    @Autowired
    private AuthenticationSuccessHandlerImpl authenticationSuccessHandler; //登录成功
    @Autowired
    private AuthenticationFailHandlerImpl authenticationFailHandler; //登录失败
    @Autowired
    private LogoutSuccessHandlerImpl logoutSuccessHandler; //退出成功


    @Bean
    public FilterInvocationSecurityMetadataSource securityMetadataSource() {
        return new FilterInvocationSecurityMetadataSourceImpl();
    }
    @Bean
    public AccessDecisionManager accessDecisionManager() {
        return new AccessDecisionManagerImpl();
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }



    /**
     * 密码加密
     *
     * @return {@link PasswordEncoder} 加密方式
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * 配置权限
     *
     * @param http http
     * @throws Exception 异常
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置登录注销路径
        http.formLogin()
                .loginProcessingUrl("/login")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailHandler)
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(logoutSuccessHandler);
        // 配置路由权限信息
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O fsi) {
                        fsi.setSecurityMetadataSource(securityMetadataSource());
                        fsi.setAccessDecisionManager(accessDecisionManager());
                        //System.out.println(LocalDateTime.now()+"走到了配置路由权限信息里面之后");
                        return fsi;
                    }
                })
                .anyRequest().permitAll()
                .and()
                // 关闭跨站请求防护
                .csrf().disable().exceptionHandling()
                //未登录处理
                .authenticationEntryPoint(authenticationEntryPoint)
                //权限不足处理
                .accessDeniedHandler(accessDeniedHandler)
                .and()
                .sessionManagement()
                .maximumSessions(20)
                .sessionRegistry(sessionRegistry());

    }
}
