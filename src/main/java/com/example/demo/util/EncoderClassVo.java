package com.example.demo.util;

import lombok.SneakyThrows;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * @author dengzhiwen <dengzhiwen@kuaishou.com>
 * Created on 2020-07-06
 */


public class EncoderClassVo implements Encoder.Text<ResultReturn> {

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }

    @SneakyThrows
    @Override
    public String encode(ResultReturn resultReturn) throws EncodeException {
        return resultReturn.toJsonString();
//        return "yes";
    }

}
