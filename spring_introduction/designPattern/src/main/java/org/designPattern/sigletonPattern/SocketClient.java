package org.designPattern.sigletonPattern;

public class SocketClient {

    // singleton 이라는 것은 자기 자신을 객체로 가지고 있어야한다.
    private static SocketClient socketClient = null;

    // 기본 생성자를 private으로 막아야한다.
    private SocketClient(){

    }

    public static SocketClient getInstance(){
        if(socketClient == null){
            socketClient = new SocketClient();
        }
        return socketClient;
    }

    public void  connect(){
        System.out.println("connect");
    }
}
