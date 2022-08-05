package com.example.ioc;

import org.springframework.beans.factory.annotation.Qualifier;

public class Encoder {

    private IEncoder iEncoder;

    // 사용하려는 bean을 Qualifier안에 써준다. 보통은 클래스 이름을 사용하지만
    // Component 어노테이션 안에 직접 이릅은 지정해주어도 된다.
    public Encoder(IEncoder iEncoder){
        // 받는 문자 타입에 타라서 불러와지는 class가 다른데 그것을 주석으로 처리하여
        // 필요할 때마다 주석을 지워주는 것은 너무 비효율적이다!!!!!
        // => 그래서 사용하는 것이? DI !
        // DI는 외부에서 내가 사용하는 객체를 주입해준다.

        // url -> 문자
        //this.iEncoder = new Base64Encoder();

        // 문자 -> url
        //this.iEncoder = new UrlEncoder();

        this.iEncoder = iEncoder;
    }

    public  void setIEncoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }
    public String encode(String message){
        return iEncoder.encode(message);
    }
}