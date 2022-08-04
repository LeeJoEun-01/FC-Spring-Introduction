package com.company.ioc;

public class Main {
    // 프로젝트 구조
    // IEncoder => url 문자열 받는 인터페이스
    // UrlEncoder => 문자 -> url 변환해주는 class
    // Base64Encoder => url -> 문자 변환해주는 class
    // Encoder => 여기서 문자를 받아 url을 변환할지, url을 받아 문자로 변환할지는 결정한다.

    public static void main(String[] args) {
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        //Base 64 encoding

        //IEncoder encoder = new Base64Encoder();
        //String result = encoder.encode(url);


        // DI는 외부에서 내가 사용하는 객체를 주입해준다.
        //Encoder encoder = new Encoder(new Base64Encoder());
        // 바꾸고 싶다면 DI인 주입 객체만 바꾼다.
        Encoder encoder = new Encoder(new UrlEncoder());
        String result = encoder.encode(url);

        System.out.println(result);

        //url encoding

        //IEncoder urlEncoder = new UrlEncoder();
        //String urlResult = urlEncoder.encode(url);


        //System.out.println(urlResult);
    }
}
