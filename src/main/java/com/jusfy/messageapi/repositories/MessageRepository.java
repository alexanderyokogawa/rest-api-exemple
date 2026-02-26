package com.jusfy.messageapi.repositories;

import com.jusfy.messageapi.models.Message;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MessageRepository {

    private final Map<Long, Message> messages = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(0);

    public Collection<Message> findAll() {
        return messages.values();
    }

    public Optional<Message> findById(Long id) {
        return Optional.ofNullable(messages.get(id));
    }

    public Message save(Message message) {
        if (message.getId() == null) {
            message.setId(sequence.incrementAndGet());
        }
        messages.put(message.getId(), message);
        return message;
    }

    public void deleteById(Long id) {
        messages.remove(id);
    }

    public boolean existsById(Long id) {
        return messages.containsKey(id);
    }
}
