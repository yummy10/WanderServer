package org.example.controller;

import org.example.entity.Message;
import org.example.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();

    }

    @PostMapping
    public void addMessage(@RequestBody Message message) {
        messageService.addMessage(message);
    }

    @PutMapping("/{messageID}/like")
    public void addLike(@PathVariable int messageID) {
        messageService.addLike(messageID);
    }

    @PutMapping("/{messageID}/sublike")
    public void subLike(@PathVariable int messageID) {
        messageService.subLike(messageID);
    }
}