package com.example.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello") // ctrl 누르면서 text 클릭하면 해당 어노테이션에 들어갈 수 있다.
    // http://localhost:9090/api/get/hello
    public String getHello(){
        return "get Hello";
    }

    @RequestMapping(path ="/hi",method = RequestMethod.GET) // get/post/put/delete가 다 동작하지 않게 뒤에 method 지정
    // http://localhost:9090/api/get/hi
    public String hi(){
        return "hi";
    }
    
    // 다양한 값을 내려받을 경우
    // http://localhost:9090/api/get/path-variable/{spring-boot}
    // http://localhost:9090/api/get/path-variable/{java}  등등
    
    @GetMapping("/path-variable/{name}")
    // GetMapping에 들어가는 변수와(name) 함수 변수(pathName)에는 이름을 다르게 정해놓았을 때
    public String pathVariable(@PathVariable(name = "name") String pathName){

        System.out.println("PathVariable"+ pathName);
        
        return pathName;
    }

    //쿼리 파라미터 받는 방법
}
