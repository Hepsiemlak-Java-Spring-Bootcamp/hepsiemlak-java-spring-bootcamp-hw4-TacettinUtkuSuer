package emlakburada.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "email_message")
public class EmailMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "messageId", nullable = false)
	private int mailId;
	private String title;
	private String emailText;
	private int fromId;
	private int toId;

	@Override
	public String toString() {
		return "EmailMessage [Degerler= " + title + ", " + emailText + ", " + fromId + ", " + toId + " ]";
	}

}
