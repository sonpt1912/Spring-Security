package com.example.buoi1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    /**
     * trong trường hợp chưa cấu hình lại form login thig
     * sẽ sử dụng form login mặc định của spring security
     * */

    @GetMapping("/sonpt")
    public String home() {
        return "home";
    }

}
