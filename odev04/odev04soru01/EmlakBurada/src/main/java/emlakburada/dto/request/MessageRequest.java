package emlakburada.dto.request;

import lombok.Data;

@Data
public class MessageRequest {

    private int messageId;
    private String title;
    private String emailText;
    private int fromId;
    private int toId;
}
