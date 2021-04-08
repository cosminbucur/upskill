package com.sda.spring.security.memory.authorities.controller;

import com.sda.spring.security.memory.authorities.config.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class DefaultController {

    private static final Logger log = LoggerFactory.getLogger(DefaultController.class);

    // http://localhost:8081/api/public
    @GetMapping("public")
    public String unProtected() {
        String currentUserLogin = SecurityUtils.getCurrentUsername();
        return "accessible by anyone: " + currentUserLogin;
    }

    // http://localhost:8081/api/role
    @GetMapping("role")
    public String roleProtected() {
        boolean authenticated = SecurityUtils.isAuthenticated();
        if (authenticated) {
            log.info("principal is authenticated");
        }

        String currentUserLogin = SecurityUtils.getCurrentUsername();
        return "accessible by admin roles only: " + currentUserLogin;
    }

    // http://localhost:8081/api/authority
    @GetMapping("authority")
    public String authorityProtected() {
        boolean hasReadAuthority = SecurityUtils.isCurrentUserInRole("READ_AUTHORITY");
        if (hasReadAuthority) {
            log.info("principal has read authority");
        }

        String currentUserLogin = SecurityUtils.getCurrentUsername();
        return "accessible by authority: " + currentUserLogin;
    }
}
