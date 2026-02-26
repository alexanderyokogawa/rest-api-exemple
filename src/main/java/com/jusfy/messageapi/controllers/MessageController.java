package com.jusfy.messageapi.controllers;

import com.jusfy.messageapi.dto.MessageDto;
import com.jusfy.messageapi.dto.MessageInputDto;
import com.jusfy.messageapi.services.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping()
    public ResponseEntity<List<MessageDto>> findAll() {
        return ResponseEntity.ok(messageService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(messageService.findById(id));
    }

    @GetMapping("/by-id")
    public ResponseEntity<MessageDto> findByIdQuery(@RequestParam(required = true) Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(messageService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<MessageDto> createMessage(@RequestBody MessageInputDto messageDto) {
        MessageDto createdMessage = messageService.create(messageDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMessage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDto> updateMessage(@PathVariable Long id, @RequestBody MessageInputDto messageDto) {
        MessageDto updatedMessage = messageService.update(id, messageDto);
        return ResponseEntity.ok(updatedMessage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        messageService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
