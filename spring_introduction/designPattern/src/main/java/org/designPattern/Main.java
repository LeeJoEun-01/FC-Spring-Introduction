package org.designPattern;

import org.designPattern.Observer.Button;
import org.designPattern.Observer.IButtonListener;
import org.designPattern.adapter.*;
import org.designPattern.aop.AopBrowser;
import org.designPattern.decorator.*;
import org.designPattern.facade.Ftp;
import org.designPattern.facade.Reader;
import org.designPattern.facade.SftpClient;
import org.designPattern.facade.Writer;
import org.designPattern.proxy.Browser;
import org.designPattern.proxy.BrowserProxy;
import org.designPattern.proxy.IBrowser;
import org.designPattern.sigletonPattern.AClazz;
import org.designPattern.sigletonPattern.BClazz;
import org.designPattern.sigletonPattern.SocketClient;
import org.designPattern.strategy.*;

import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {
//  <Singleton>
//        AClazz aClazz = new AClazz();
//        BClazz bClazz = new BClazz();
//
//        SocketClient aClient = aClazz.getSocketClient();
//        SocketClient bClient = bClazz.getSocketClient();
//
//        System.out.println("두개의 객체가 동일한가?");
//        System.out.println(aClient.equals(bClient));
//        // singleton으로 만들지 않으면 두 객체는 동일하지 않다!

//  <Adapter>
        /*HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        //connect(cleaner); 110v에 220v를 끼려면 에러가 나기 때문에 돼지코 같은 adapter가 필요하다.
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);

        AirConditioner airConditioner = new AirConditioner();
        Electronic110V airAdapter = new SocketAdapter(airConditioner);
        connect(airAdapter);*/

//  <Proxy>
        /*
        Browser browser = new Browser("www.naver.com");
        browser.show(); //loading
        browser.show(); //loading

//      구현체 자체는 건드리지 않고 캐싱하는 기능 넣기
        IBrowser browser2 = new BrowserProxy("www.naver.com");
        browser2.show(); //loading
        browser2.show(); //cache
        browser2.show(); //cache
        browser2.show(); //cache
        browser2.show(); //cache

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        //람다식
        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                ()->{
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                ()->{
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                }
        );

        aopBrowser.show();
        System.out.println("loading time: "+end.get());

        aopBrowser.show();
        System.out.println("loading time: "+end.get()); // 두 번째는 cache를 활용하기 때문에 0초가 걸린다.
        */

//  <decorator>
        /*
        ICar audi = new Audi(1000);
        audi.showPrice();

        //a3
        ICar audi3 = new A3(audi, "A3");
        audi3.showPrice();
        //a4
        ICar audi4 = new A4(audi, "A4");
        audi4.showPrice();
        //a5
        ICar audi5 = new A5(audi, "A5");
        audi5.showPrice();
         */

//  <Observer>
        /*
        Button button = new Button("버튼1");

        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });

        // 클릭이 일어나면 이벤트 리스너를 통해서 전달해주는 형태를 observer 패턴이다.
        button.click("메세지 전달 : click 1");
        button.click("메세지 전달 : click 2");
        button.click("메세지 전달 : click 3");
        button.click("메세지 전달 : click 4");
         */

//  <facade>
        /*
        Ftp ftpClient = new Ftp("www.foo.co.kr", 22, "/home/etc");
        ftpClient.connect();
        ftpClient.moveDirectory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.write();

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        // 여러 가지 객체 의존성들을
        reader.fileDisconnect();
        writer.fileDisconnect();
        ftpClient.disConnect();

        // 안쪽으로 숨겨 정면만 바라보게 한다.
        SftpClient sftpClient = new SftpClient("www.foo.co.kr", 22,"/home/etc", "text.tmp");
        sftpClient.connect();
        sftpClient.write();
        sftpClient.read();
        sftpClient.disConnect();
         */

//  <Strategy>
        //원본 객체는 그대로 두고 전략만 바꾼다.
        Encoder encoder = new Encoder();

        //base64
        EncodingStrategy base64 = new Base64Strategy();
        //normal
        EncodingStrategy normal = new NormalStrategy();

        String message = "hello java";

        //전략 세팅
        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);
        System.out.println(base64Result);

        //전략 세팅
        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);
        System.out.println(normalResult);

        encoder.setEncodingStrategy(new AppendStrategy());
        String appendResult = encoder.getMessage(message);
        System.out.println(appendResult);
    }

    // 110v 콘센트
    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }
}
