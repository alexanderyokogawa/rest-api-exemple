package com.jusfy.messageapi.models;

import com.jusfy.messageapi.dto.MessageDto;

import java.io.Serializable;
import java.util.Objects;

public class Message  implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String message;

    public Message(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Message() {

    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
            "id=" + id +
            ", message='" + message + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Message message1)) return false;
        return Objects.equals(getId(), message1.getId()) && Objects.equals(getMessage(), message1.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMessage());
    }

    public MessageDto toDto() {
        return new MessageDto(this.id, this.message);
    }
}
