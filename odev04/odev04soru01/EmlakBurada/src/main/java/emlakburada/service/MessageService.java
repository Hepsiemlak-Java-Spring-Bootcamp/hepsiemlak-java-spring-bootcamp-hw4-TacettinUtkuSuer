package emlakburada.service;

import emlakburada.dto.request.MessageRequest;
import emlakburada.dto.response.AdvertResponse;
import emlakburada.dto.response.MessageResponse;
import emlakburada.model.Advert;
import emlakburada.model.Message;
import emlakburada.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MessageService {


    @Autowired
    private MessageRepository messageRepository;

    private static int messageId = 4;

    public List<MessageResponse> findAll(){
        List<MessageResponse> messageList = new ArrayList<>();
        for (Message message : messageRepository.findAll()) {
            messageList.add(convertToMessageResponse(message));
        }
        return messageList;
    }

    public MessageResponse findOne(int messageId){

        Optional<Message> foundMessage = messageRepository.findById(messageId);

        Message message = convertToMessage(foundMessage);

        try {

            if (message == null) {
                throw new Exception("Mesaj bulunamadı.");
            }

            Message savedMessage = messageRepository.save(message);

            return convertToMessageResponse(savedMessage);
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        return null;
    }

        // -----------------------------------------------------------------------------------------------------------------------------
    private MessageResponse convertToMessageResponse(Message message) {
        MessageResponse response = new MessageResponse();
        response.setTitle(message.getTitle());
        response.setEmailText(message.getEmailText());
        response.setToId(message.getToId());
        response.setFromId(message.getFromId());
        response.setMessageId(message.getMessageId());
        return response;
    }

    private Message convertToMessage(Optional<Message> foundMessage) {

        Message message = null;

        if (foundMessage.isPresent()) {
            message = new Message();
            message.setMessageId(foundMessage.get().getMessageId());
            message.setTitle(foundMessage.get().getTitle());
            message.setEmailText(foundMessage.get().getEmailText());
            message.setFromId(foundMessage.get().getFromId());
            message.setToId(foundMessage.get().getToId());
        } else {
            log.info("Mesaj Bulunamadı!");
        }

        return message;
    }

    public void deleteMessageByMessageId(int messageId) {
        messageRepository.deleteById(messageId);
    }

}
