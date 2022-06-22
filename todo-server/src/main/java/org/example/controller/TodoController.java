package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.model.TodoResponse;
import org.example.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
// 기본적으로 '모든 도메인, 모든 요청방식'에 대해 허용한다
@AllArgsConstructor
@RestController
// Controller 명시
@RequestMapping("/")  //베이스 url 설정
// 요청 들어온 URL의 요청과 Annotation value 값이 일치하면 해당 클래스나 메소드가 실행된다.
public class TodoController {

    private final TodoService service;

    @PostMapping
    public ResponseEntity<TodoResponse> create() {
        System.out.println("Create");
        return null;
    }

    @GetMapping("{id")   //경로에서 id값을 받아 가져온다.
    public ResponseEntity<TodoResponse> readOne() {
        System.out.println("READ ONE");
        return null;
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> readAll() {
        System.out.println("READ ALL");
        return null;
    }

    @PatchMapping("{id}") //경로에서 id값을 받아 해당 아이디를 가진 entity를 업데이트
    public ResponseEntity<TodoResponse> update() {
        System.out.println("UPDATE");
        return null;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOne() {
        System.out.println("DELETE ONE");
        return null;
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll() {
        System.out.println("DELETE ALL");
        return null;
    }
}
