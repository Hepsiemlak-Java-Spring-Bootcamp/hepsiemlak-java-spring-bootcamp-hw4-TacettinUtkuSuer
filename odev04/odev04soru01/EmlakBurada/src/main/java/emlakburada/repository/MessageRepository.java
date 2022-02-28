package emlakburada.repository;

import emlakburada.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


public interface MessageRepository extends JpaRepository<Message, Integer> {


    /*
    private static List<Message> messageList = new ArrayList<>();

    static {
        messageList.add(prepareMessage("Hala satılık mı", "icerik.....................",1));
        messageList.add(prepareMessage("hala kiralık mı", "icerik.....................",2));
        messageList.add(prepareMessage("en son kac olur", "icerik...................",3));
        messageList.add(prepareMessage("ne zaman evi görebilirim", "icerik....................",4));
    }

    public List<Message> fetchAllMessages() {
        return messageList;
    }


    private static Message prepareMessage(String baslik, String icerigi, int messageId) {
        Message message = new Message();
        message.setBaslik(baslik);
        message.setIcerigi(icerigi);
        message.setMessageId(messageId);
        message.setGondericiId(1);
        message.setAliciId(2);
        return message;
    }

    public Message saveMessage(Message message) {
        messageList.add(message);
        System.out.println(message.toString());
        return message;
    }


     */
}
