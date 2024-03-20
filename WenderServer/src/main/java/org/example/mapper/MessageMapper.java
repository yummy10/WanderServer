package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.Message;

import java.util.List;

@Mapper
public interface MessageMapper {
    List<Message> getAllMessages();
    void insertMessage(Message message);
    void incrementLike(int messageID);
}