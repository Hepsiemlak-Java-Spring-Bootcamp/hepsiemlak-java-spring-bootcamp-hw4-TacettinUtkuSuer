package emlakburada.client.response;

import emlakburada.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BannerResponse {

	private int bannerId;
	private int advertId;
	private String phone;
	private int total;
	private int addressId;

}
