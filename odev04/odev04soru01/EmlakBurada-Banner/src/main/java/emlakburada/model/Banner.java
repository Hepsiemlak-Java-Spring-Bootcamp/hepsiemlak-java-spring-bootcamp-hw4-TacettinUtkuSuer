package emlakburada.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Banner {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bannerID", nullable = false)
	private int bannerId;
	private int advertId;
	private String phone;
	private int total;
	private int addressId;


}
