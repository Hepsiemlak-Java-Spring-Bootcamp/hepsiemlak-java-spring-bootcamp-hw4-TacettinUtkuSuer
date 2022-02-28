package emlakburada.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "email_message")
public class Message {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "messageId", nullable = false)
		private int messageId;
		private String title;
		private String emailText;
		private int fromId;
		private int toId;

		@ManyToOne
		@JoinColumn(name = "user_id", referencedColumnName = "user_id")
		private User user;

	public Message(String title, String emailText, int fromId, int toId) {
		this.title = title;
		this.emailText = emailText;
		this.fromId = fromId;
		this.toId = toId;
	}
}
