package com.dpet.core.init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.dpet.core.interceptor.LoginInterceptor;
import com.dpet.framework.interceptor.DataInterceptor;

/**
 * @author lijun
 */
@SuppressWarnings("ALL")
@Configuration
@EnableWebMvc
@ComponentScan
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/templates/");
        resolver.setSuffix(".ftl");
        return resolver;
    }

    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver bean = new CommonsMultipartResolver();
        bean.setDefaultEncoding("UTF-8");
        bean.setMaxUploadSize(8388608);
        return bean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 数据初始化拦截器
        registry.addInterceptor(new DataInterceptor()).addPathPatterns("/**");
        // 登录拦截器
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/web/**").excludePathPatterns("/feedback/**")
                .excludePathPatterns("/article/**").excludePathPatterns("/course/**").excludePathPatterns("/login/**");
    }

}
