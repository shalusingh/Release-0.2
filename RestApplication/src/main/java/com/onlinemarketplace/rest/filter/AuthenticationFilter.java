/**
 *
 */
package com.onlinemarketplace.rest.filter;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlinemarketplace.dataentity.enums.Right;
import com.onlinemarketplace.datamanagement.service.AuthenticationService;
import com.onlinemarketplace.rest.responce.Response;

/**
 * @author jitendra Dec 23, 2015 2015
 */
public class AuthenticationFilter
    extends HandlerInterceptorAdapter {

    private AuthenticationService authenticationService;

    /**
     * @param authenticationService
     */
    public AuthenticationFilter(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        String authCode = null;
        Long appId = null;

        response.setContentType("application/json");
        Response<com.onlinemarketplace.dataentity.domain.Authentication> response2 =
            new Response<com.onlinemarketplace.dataentity.domain.Authentication>();
        response2.setMessage("Authentication request.");
        response2.setStatus(false);
        response2.setResponceCode(HttpStatus.UNAUTHORIZED.value());

        ObjectMapper mapper = new ObjectMapper();
        String objectJson = mapper.writeValueAsString(response2);

        if (request.getHeader("auth") == null) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().append(objectJson);
            return false;
        } else {
            authCode = request.getHeader("auth");
        }

        if (request.getHeader("appId") == null) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().append(objectJson);
            return false;
        } else {
            appId = Long.parseLong(request.getHeader("appId"));
        }

        com.onlinemarketplace.dataentity.domain.Authentication authentication = null;
        if (handler instanceof HandlerMethod) {

            HandlerMethod method = (HandlerMethod) handler;
            if (method.getMethod().isAnnotationPresent(Authentication.class)) {
                authentication = authenticationService.getRepository().get(authCode, appId);
                if (authentication == null) {
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    return false;
                }
                for (Annotation annotation : method.getMethod().getAnnotations()) {
                    if (annotation instanceof Authentication) {
                        Right right = ((Authentication) annotation).right();
                        if (!right.equals(authentication.getRight())) {
                            response.setStatus(HttpStatus.UNAUTHORIZED.value());
                            response.getWriter().append(objectJson);
                            return false;
                        }
                    }
                }

            }
        }
        return true;

    }

}
