package org.designPattern.sigletonPattern;

public class AClazz {
    // s가 예약어이기 때문에 z를 사용한다.
    private SocketClient socketClient;

    public AClazz(){
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient(){
        return this.socketClient;
    }
}
