package com.fm.config.mvc;

import com.fm.authority.interceptor.AuthorizationInterceptor;
import com.fm.authority.resolver.InjectUserMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by aiyi on 2017/5/6.
 */
@Component
public class MvcConfig extends WebMvcConfigurerAdapter {


    @Autowired
    private InjectUserMethodArgumentResolver injectUserMethodArgumentResolver;

    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(injectUserMethodArgumentResolver);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor);
    }


}
