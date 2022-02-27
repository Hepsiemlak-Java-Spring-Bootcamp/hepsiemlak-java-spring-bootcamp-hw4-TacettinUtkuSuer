package emlakburada.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class MessageResponse {

    private int messageId;
    private String title;
    private String emailText;
    private int fromId;
    private int toId;

}
