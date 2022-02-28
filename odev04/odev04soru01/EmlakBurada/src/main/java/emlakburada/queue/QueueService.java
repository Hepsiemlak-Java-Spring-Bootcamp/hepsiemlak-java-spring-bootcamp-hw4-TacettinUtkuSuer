package emlakburada.queue;

import emlakburada.model.Message;

public interface QueueService {
	
	void sendMessage(Message message);

}
