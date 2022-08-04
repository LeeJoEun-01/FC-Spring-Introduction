package com.example.objectmapper;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private String name;
    private int age;

    @JsonProperty("phone_number")
    private String phoneNumber;

    // 디폴트 생성자
    public User(){
        this.name = null;
        this.age = 0;
        this.phoneNumber = null;
    }
    public User(String name, int age, String phoneNumber){
        this.name = name;
        this.age = age;
        this.phoneNumber =phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // getter, setter 이외에 특정 메서드를 만드는 경우
    // 내가 작성한 클래스에서 object mapper가 활용될 경우
    // 메소드 명에 'get'이 있으면 안된다!
    // 왜냐면 object mapper가 get 메서드로 데이터를 받아오는 데 다른 메서드에 get이라는 이름이 있는 경우
    // 에러를 발생시킨다.
    public User defaultUser(){
        return new User("default", 0, "default");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
