package org.example.service;

import org.example.entity.Message;
import org.example.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<Message> getAllMessages() {
        return messageMapper.getAllMessages();
    }

    @Override
    public void addMessage(Message message) {
        messageMapper.insertMessage(message);
    }

    @Override
    public void addLike(int messageID) {
        messageMapper.incrementLike(messageID);
    }
    @Override
    public void subLike(int messageID) {
        messageMapper.decrementLike(messageID);
    }
}