package com.zuul.gateway.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "userApi", url = "http://localhost:8081/account")
public interface UserApi {

    @GetMapping(value = "/validate")
    String validate(@RequestParam("username") String username, @RequestParam("password") String password);
}
