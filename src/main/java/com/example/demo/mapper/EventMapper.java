package com.example.demo.mapper;

import com.example.demo.entry.Event;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author dengzhiwen <dengzhiwen@kuaishou.com>
 * Created on 2020-07-06
 */

@Mapper
public interface EventMapper {

    @Select("select * from event_info")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "eventType", column = "event_type"),
            @Result(property = "eventDate", column = "event_date"),
            @Result(property = "eventLocation", column = "event_location"),
            @Result(property = "eventDesc", column = "event_desc"),
            @Result(property = "oldPerson", column = "oldperson_id")

    })
    List<Event> getAll();

    @Insert("insert into event_info(event_type, event_date, event_location, event_desc, oldperson_id) " +
            "values(#{eventType}, #{eventDate}, #{eventLocation}, #{eventDesc}, #{oldPerson})")
    void addEvent(Event event);
}
