package emlakburada.queue;

import emlakburada.model.Message;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakburada.config.RabbitMqConfig;

@Service
public class RabbitMqService implements QueueService {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Autowired
	private RabbitMqConfig config;

	@Override
	public void sendMessage(Message message) {
		rabbitTemplate.convertAndSend(config.getExchange(), config.getRoutingkey(), message);
	}

}
