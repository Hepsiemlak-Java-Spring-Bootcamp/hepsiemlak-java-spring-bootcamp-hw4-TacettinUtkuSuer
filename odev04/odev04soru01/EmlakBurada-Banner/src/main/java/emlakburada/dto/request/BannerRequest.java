package emlakburada.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BannerRequest {

	private int advertId;
	private String phone;
	private int total;
	private int addressId;

}

