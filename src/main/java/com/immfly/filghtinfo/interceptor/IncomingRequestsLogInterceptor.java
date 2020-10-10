package com.immfly.filghtinfo.interceptor;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.stream.Collectors;

@Component
public class IncomingRequestsLogInterceptor extends HandlerInterceptorAdapter {

    private final Logger LOGGER = LoggerFactory.getLogger(IncomingRequestsLogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURL().toString();

        if (!Strings.isEmpty(request.getQueryString())) {
            url += "?" + request.getQueryString();
        }

        String headers = Collections.list(request.getHeaderNames())
                .stream()
                .map(headerName -> {
                    String values = String.join(", ", Collections.list(request.getHeaders(headerName)));

                    return "[" + headerName + "=" + values + "]";
                })
                .collect(Collectors.joining(","));

        LOGGER.info("Incoming Request: "+ request.getMethod() + " " + url + " HEADERS: " + headers);

        return true;
    }
}
