package emlakburada.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import emlakburada.model.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", nullable = false)
	private int id;
	@Enumerated(EnumType.STRING)
	private UserType userType; // bireysel & kurumsal & yeniTip
	private String name;
	private String email;
	private String photo;
	private String bio;


	@OneToMany(mappedBy = "user")
	private List<Message> mesajKutusu;

}
