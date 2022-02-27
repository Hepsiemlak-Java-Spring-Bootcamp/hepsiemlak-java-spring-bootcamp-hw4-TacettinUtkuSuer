package emlakburada.controller;


import emlakburada.dto.request.AdvertRequest;
import emlakburada.dto.request.MessageRequest;
import emlakburada.dto.response.AdvertResponse;
import emlakburada.dto.response.MessageResponse;
import emlakburada.model.Message;
import emlakburada.queue.QueueService;
import emlakburada.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private QueueService queueService;

    @GetMapping(value = "/messages")
    public ResponseEntity<List<MessageResponse>> getAllMessage() {
        return new ResponseEntity<>(messageService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/messages/{messageId}")
    public ResponseEntity<MessageResponse> getUserByMessageId(@PathVariable(required = false) int messageId) {
        return new ResponseEntity<>(messageService.findOne(messageId), HttpStatus.OK);
    }

    @PostMapping(value = "/messages")
    public ResponseEntity<MessageResponse> sendMessage(@RequestBody Message message) {
        queueService.sendMessage(message);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/messages/{messageId}")
    public ResponseEntity<AdvertResponse> deleteMessageByMessageId(@PathVariable(required = false) int messageId) {
        messageService.deleteMessageByMessageId(messageId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
