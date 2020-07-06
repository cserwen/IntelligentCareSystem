package com.example.demo.entry;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author dengzhiwen <dengzhiwen@kuaishou.com>
 * Created on 2020-07-06
 */

@Getter
@Setter
//@ToString
public class Event {

    private int id;
    private int eventType;
    private Date eventDate;
    private String eventLocation;
    private String eventDesc;
    private int oldPerson;

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"eventType\":" + eventType +
                ", \"eventDate\":\"" + eventDate +
                "\", \"eventLocation\":\"" + eventLocation+
                "\", \"eventDesc\":\"" + eventDesc +
                "\", \"oldPerson\":" + oldPerson +
                '}';
    }
}
