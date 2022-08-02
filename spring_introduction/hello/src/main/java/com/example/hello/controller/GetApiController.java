package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    // 쿼리 파라미터 받는 방법
    // http://localhost:9090/api/get/query-param?user=joeun&email=joeun1005@naver.com&aga=22

    //방법1) Map으로 받기
    @GetMapping(path= "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){
        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach( entry ->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+" = "+entry.getValue()+"\n");
        });

        return sb.toString();
    }

    //방법2) 변수마다 @RequestParam으로 받는 법 (너무 번거로움)
    @GetMapping(path = "query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name+" "+email+" "+age;
    }

    //방법3) DTO 형태로 방법 (현업에서 제일 많이 씀)
    @GetMapping(path = "query-param03")
    public String queryParam03(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }

}
