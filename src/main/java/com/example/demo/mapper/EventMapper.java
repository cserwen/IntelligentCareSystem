package com.example.demo.mapper;

import com.example.demo.entry.Event;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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
}
