package com.sda.spring.security.memory.authorities.controller;

import com.sda.spring.security.memory.authorities.config.SecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class PublicRestApiController {

    // http://localhost:8081/api/public
    @GetMapping("public")
    public String unProtected() {
        String currentUserLogin = SecurityUtils.getCurrentUsername();
        return "accessible by anyone: " + currentUserLogin;
    }

    // http://localhost:8081/api/role
    @GetMapping("role")
    public String roleProtected() {
        String currentUserLogin = SecurityUtils.getCurrentUsername();
        return "accessible by admin roles only: " + currentUserLogin;
    }

    // http://localhost:8081/api/authority
    @GetMapping("authority")
    public String authorityProtected() {
        String currentUserLogin = SecurityUtils.getCurrentUsername();
        return "accessible by authority: " + currentUserLogin;
    }
}
