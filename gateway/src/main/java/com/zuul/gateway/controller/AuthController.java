package com.zuul.gateway.controller;


import com.zuul.gateway.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URI;
import java.net.http.HttpClient;

@Controller
public class AuthController {

    @GetMapping("/")
    public String home(HttpServletRequest httpServletRequest, HttpSession session) {
        return login(httpServletRequest, session);
    }

    @GetMapping(value = "/login")
    public String login(HttpServletRequest httpServletRequest, HttpSession session) {
        HttpSession httpSession = httpServletRequest.getSession(false);
        if (httpSession != null) {
            if (httpSession.getAttribute("user") != null) {
                String username = ((User) httpSession.getAttribute("user")).getName();
                System.out.println(username);
                session.setAttribute("account", username.toUpperCase());
                return "admin".equalsIgnoreCase(((User) httpSession.getAttribute("user")).getRole()) ?
                        "admin" : "index";
            }
        }
        return "login";
    }

}

