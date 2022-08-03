package com.example.put.controller;

import com.example.put.dto.PostRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put/{userId}")
    public PostRequestDto put(@RequestBody PostRequestDto requestDto, @PathVariable(name = "userId") Long Id){
        // @PutMapping("/put")
        //System.out.println(requestDto);
        System.out.println(Id);
        // return을 해주면 그게 바로 response(응답)이고 json 그대로 보내진다.
        return requestDto;

    }
}

//Json 디자인
//{
//    "name" : "joeun",
//    "age" : 22,
//    "car_list" : [
//        {
//            "name" : "BMW",
//            "car_number" : "11가 1234"
//        },
//        {
//            "name" : "A4",
//            "car_number" : "22가 3456"
//        }
//    ]
//}