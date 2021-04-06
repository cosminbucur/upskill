package com.sda.spring.security.memory.roles.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class PublicRestApiController {

    // http://localhost:8081/api/public
    @GetMapping("public")
    public String unProtected() {
        return "accessible by anyone";
    }

    // http://localhost:8081/api/admin
    @GetMapping("admin")
    public String adminProtected() {
        return "accessible by admin roles only";
    }
}
