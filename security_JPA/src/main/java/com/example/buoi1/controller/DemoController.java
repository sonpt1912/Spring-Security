package com.example.buoi1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {

    /**
     * trong trường hợp chưa cấu hình lại form login thig
     * sẽ sử dụng form login mặc định của spring security
     */

    @GetMapping("/home")
    public String home() {
        return "home";
    }


    @GetMapping("/daily")
    public String daily() {
        return "daily";
    }

    @GetMapping("/month")
    public String month() {
        return "month";
    }

    @GetMapping("/leader")
    public String leader() {
        return "leader";
    }

    @GetMapping("/system")
    public String system() {
        return "system";
    }


    @GetMapping("/acces-denied")
    public String fobbident() {
        return "forbiddent";
    }

}
