package com.example.demo.socket;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.demo.mapper.EventMapper;
import com.example.demo.util.EncoderClassVo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.annotation.Resource;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.ServerEndpointConfig;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author dengzhiwen <dengzhiwen@kuaishou.com>
 * Created on 2020-07-06
 */

@Component
@ServerEndpoint(value = "/ws/webSocket", encoders = {EncoderClassVo.class})
public class WebSocket {

    private Session session;
    private static CopyOnWriteArraySet<WebSocket> copyOnWriteArraySet = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        copyOnWriteArraySet.add(this);
        System.out.println("websocket有新的连接, 总数:"+ copyOnWriteArraySet.size());
    }

    @OnClose
    public void onClose(){
        copyOnWriteArraySet.remove(this);
        System.out.println("websocket连接断开, 总数:"+ copyOnWriteArraySet.size());
    }

    @OnMessage
    public void onMessage(String message){
        System.out.println("websocket收到客户端发来的消息:"+message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误：" + error.getMessage() + "; sessionId:" + session.getId());
        error.printStackTrace();
    }
    
    public void sendMessage(Object object){
        for (WebSocket webSocket : copyOnWriteArraySet) {
            System.out.println("websocket广播消息：" + object.toString());
            try {
                webSocket.session.getBasicRemote().sendObject(object);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message){
        for (WebSocket webSocket : copyOnWriteArraySet) {
            System.out.println("websocket广播消息：" + message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
