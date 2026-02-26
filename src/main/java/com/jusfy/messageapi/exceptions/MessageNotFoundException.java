package com.jusfy.messageapi.exceptions;

public class MessageNotFoundException extends RuntimeException {
    public MessageNotFoundException(Long id) {
        super("Message with id " + id + " not found.");
    }
}
