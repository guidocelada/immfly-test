package com.immfly.filghtinfo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.immfly.filghtinfo.controller.ErrorResponseControllerAdvice;
import com.immfly.filghtinfo.controller.resource.ErrorResource;
import com.immfly.filghtinfo.controller.resource.ErrorResourceCodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthExceptionHandler implements AuthenticationEntryPoint, AccessDeniedHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(AuthExceptionHandler.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        handle(response, authException);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        handle(response, accessDeniedException);
    }

    private void handle(HttpServletResponse response, Exception ex) throws IOException {

        LOGGER.warn("Access denied, " + ex.getMessage());

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json");
        response.getWriter().write(new ObjectMapper()
                .writeValueAsString(new ErrorResource(ErrorResourceCodes.UNAUTHORIZED, "You are not authorized :(")));
        response.getWriter().flush();
        response.getWriter().close();
    }
}
