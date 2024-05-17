package com.example.task_81c;

import java.util.List;

public class Request {
    private String userMessage;
    private List<Entry> chatHistory;
    public Request(String userMessage, List<Entry> chatHistory){
        this.userMessage = userMessage;
        this.chatHistory = chatHistory;
    }
    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public List<Entry> getChatHistory() {
        return chatHistory;
    }

    public void setChatHistory(List<Entry> chatHistory) {
        this.chatHistory = chatHistory;
    }

}
