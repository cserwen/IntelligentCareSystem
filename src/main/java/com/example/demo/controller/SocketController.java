package com.example.demo.controller;

import com.example.demo.entry.Event;
import com.example.demo.mapper.EventMapper;
import com.example.demo.socket.WebSocket;
import com.example.demo.util.ResultReturnUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dengzhiwen <dengzhiwen@kuaishou.com>
 * Created on 2020-07-06
 */

@RestController
public class SocketController {

    @Resource
    private WebSocket webSocket;

    @Resource
    private EventMapper eventMapper;

    @RequestMapping("/test")
    public void sendMessage(){

        List<Event> list = eventMapper.getAll();
        System.out.println(list.get(0).getEventDesc());
        webSocket.sendMessage(ResultReturnUtil.success("success", list));
    }
}
