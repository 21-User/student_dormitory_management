package com.fc.config;

import com.fc.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: T21
 * @date: 2022/5/8.
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                //添加要拦截的路径
                .addPathPatterns("/**")
                //添加放行的路径
                .excludePathPatterns(
                        "/login",
                        "/captcha",
                        "/login.html",
                        "/400.html",
                        "/500.html",
                        "/**/*.js",
                        "/**/*.css",
                        "/**/*.woff",
                        "/**/*.woff2",
                        "/**/*.ttf",
                        "/**/*.eot",
                        "/**/*.otf",
                        "/**/*.svg",
                        "/**/*.less",
                        "/**/*.scss",
                        "/**/*.jpg",
                        "/**/*.ico",
                        "/**/*.jpeg",
                        "/**/*.png",
                        "/**/*.bmp"
                );
    }
}
