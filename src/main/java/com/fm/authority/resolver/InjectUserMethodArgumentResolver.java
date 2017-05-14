package com.fm.authority.resolver;


import com.fm.authority.annotion.InjectUser;
import com.fm.mapper.FmUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * Created by mac on 2016/11/28.
 * 注解@InjectUser的处理器
 * 参数注入实现SpringMVC HandlerMethodArgumentResolver
 */

@Component
public class InjectUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private FmUserMapper userMapper;


    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterAnnotation(InjectUser.class) != null;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        //取出在拦截器放入的userID。从数据库查询出当前id对应的对象，注入
        Long userId = (Long) nativeWebRequest.getAttribute("userId", RequestAttributes.SCOPE_REQUEST);
        if (userId != null) {
            return userMapper.selectByPrimaryKey(userId);
        }
        throw new MissingServletRequestPartException("======ERROR======");
    }
}
