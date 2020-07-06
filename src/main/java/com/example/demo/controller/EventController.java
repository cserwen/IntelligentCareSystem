package com.example.demo.controller;

import com.example.demo.entry.Event;
import com.example.demo.mapper.EventMapper;
import com.example.demo.socket.WebSocket;
import com.example.demo.util.ResultReturnUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dengzhiwen <dengzhiwen@kuaishou.com>
 * Created on 2020-07-06
 */

@RestController()
@RequestMapping("/event")
public class EventController {

    private Logger logger = LoggerFactory.getLogger(EventController.class);


    @Resource
    private WebSocket webSocket;

    @Resource
    private EventMapper eventMapper;

    @RequestMapping("add")
    public void sendMessage(@RequestBody Event event){

        logger.info("发生事件：" + event);

        List<Event> list = new ArrayList<>();
        list.add(event);
        webSocket.sendMessage(ResultReturnUtil.success("success", list));

        eventMapper.addEvent(event);
    }
}
