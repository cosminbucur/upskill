package com.sda.patterns.behavioral.observer;

public class Message {

    private final String messageContent;

    public Message(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessageContent() {
        return messageContent;
    }
}
