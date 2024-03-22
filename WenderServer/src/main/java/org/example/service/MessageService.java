package org.example.service;

import org.example.entity.Message;

import java.util.List;

public interface MessageService {
    List<Message> getAllMessages();
    void addMessage(Message message);
    void addLike(int messageID);
    void subLike(int messageID);
    Integer countPlacesByName(String placeName);
    List<Message> ShowingUserComments(Integer userID);
}