package org.designPattern.sigletonPattern;

public class AClazz {
    // s가 예약어이기 때문에 z를 사용한다.
    private SocketClient socketClient;

    public AClazz(){
        this.socketClient = SocketClient.getInstance(); //singleton 방식
        //this.socketClient = new SocketClient(); //새로 객체를 만드는 방식
    }

    public SocketClient getSocketClient(){
        return this.socketClient;
    }
}
