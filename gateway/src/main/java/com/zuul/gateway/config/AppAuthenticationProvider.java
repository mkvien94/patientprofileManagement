package com.zuul.gateway.config;

import com.jayway.jsonpath.DocumentContext;
import com.zuul.gateway.api.UserApi;
import com.zuul.gateway.model.User;
import com.zuul.gateway.service.JsonService;
import org.apache.catalina.Authenticator;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;


public class AppAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    UserApi userApi;

    @Autowired
    JsonService jsonService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            String res = userApi.validate(authentication.getName(), authentication.getCredentials().toString());//"{\"role\":\"admin\",\"code\":\"214\"}"
            DocumentContext dc = jsonService.toDocumentContext(res);
            String role = dc.read("$.role", String.class).toUpperCase();
            String code = dc.read("$.code", String.class);
            User user = new User();
            user.setCode(code);
            user.setRole(role);
            user.setName(authentication.getName());

            RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
            if (requestAttributes instanceof ServletRequestAttributes) {
                HttpServletRequest httpServletRequest = ((ServletRequestAttributes) requestAttributes).getRequest();
                HttpSession httpSession = httpServletRequest.getSession();
                httpSession.setAttribute("user", user);
                List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
                grantedAuthorities.add(new SimpleGrantedAuthority(String.join("_", "ROLE", role)));
                authentication = new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials().toString(),
                        grantedAuthorities);
                SecurityContext sc = SecurityContextHolder.getContext();
                sc.setAuthentication(authentication);
                 httpSession.setAttribute(SPRING_SECURITY_CONTEXT_KEY, sc);
            }
            return authentication;
        } catch (UsernameNotFoundException e) {
            throw e;
        }
    }

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(UsernamePasswordAuthenticationToken.class);
    }
}
