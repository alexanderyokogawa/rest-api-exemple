package com.jusfy.messageapi.services;

import com.jusfy.messageapi.dto.MessageDto;
import com.jusfy.messageapi.dto.MessageInputDto;
import com.jusfy.messageapi.exceptions.MessageNotFoundException;
import com.jusfy.messageapi.models.Message;
import com.jusfy.messageapi.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    //Listar todos os dados em memória
    public List<MessageDto> findAll() {
        return messageRepository.findAll().stream()
            .sorted(Comparator.comparing(Message::getId))
            .map(Message::toDto)
            .toList();
    }

    public MessageDto findById(Long id) {
        return messageRepository.findById(id)
            .orElseThrow(() -> new MessageNotFoundException(id))
            .toDto();
    }

    public MessageDto create(MessageInputDto messageInputDto) {
        Message message = new Message();
        message.setMessage(messageInputDto.message());
        return messageRepository.save(message).toDto();
    }

    public MessageDto update(Long id, MessageInputDto messageInputDto) {
        Message existingMessage = messageRepository.findById(id)
            .orElseThrow(() -> new MessageNotFoundException(id));
        existingMessage.setMessage(messageInputDto.message());
        return messageRepository.save(existingMessage).toDto();
    }

    public void delete(Long id) {
        if (!messageRepository.existsById(id)) {
            throw new MessageNotFoundException(id);
        }
        messageRepository.deleteById(id);
    }

}
