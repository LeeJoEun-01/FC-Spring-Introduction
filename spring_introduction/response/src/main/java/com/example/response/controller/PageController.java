package com.example.response.controller;


import com.example.response.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//html 페이지 리소스를 찾는다.
public class PageController {

    @RequestMapping("/main")
    public String main(){
        return "main.html";
    }

    //json을 내려주는 방법
    // 1. ResponseEntity

    // 2. ResponseBody
    @ResponseBody
    @GetMapping("/user")
    public User user(){
        // User user = new User();
        // var을 사용하여  User라는 타입을 추론해서 사용한다.
        var user = new User();
        user.setName("joeun");
        user.setAddress("패스트 캠퍼스");
        return user;
    }
}
