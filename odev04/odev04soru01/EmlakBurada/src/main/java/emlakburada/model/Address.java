package emlakburada.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "addressID", nullable = false)
	private int addressId;
	private String il;
	private String ilce;
	private String acikAdres;

	public Address(String il, String ilce, String acikAdres) {
		this.il = il;
		this.ilce = ilce;
		this.acikAdres = acikAdres;
	}
}
