package org.example.entity;

public class MyString {
    public MyString(String s) {
        setMessage(s);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
}

