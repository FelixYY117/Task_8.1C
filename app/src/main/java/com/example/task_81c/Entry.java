package com.example.task_81c;

public class Entry {
    private String User;
    private String Llama;

    public Entry(String userMessage, String chatBotResponse) {
        this.User = userMessage;
        this.Llama = chatBotResponse;
    }
    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        this.User = user;
    }

    public String getLlama() {
        return Llama;
    }

    public void setLlama(String llama) {
        this.Llama = llama;
    }
}
