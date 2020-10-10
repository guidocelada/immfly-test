package com.immfly.filghtinfo.config;

import com.immfly.filghtinfo.interceptor.IncomingRequestsLogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorsConfiguration implements WebMvcConfigurer {

    private final IncomingRequestsLogInterceptor incomingRequestsLogInterceptor;


    public InterceptorsConfiguration(IncomingRequestsLogInterceptor incomingRequestsLogInterceptor) {
        this.incomingRequestsLogInterceptor = incomingRequestsLogInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(incomingRequestsLogInterceptor);
    }
}
