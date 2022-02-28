package emlakburada.client;

import emlakburada.dto.request.AdvertRequest;
import emlakburada.model.Address;
import emlakburada.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import emlakburada.client.request.BannerRequest;
import emlakburada.client.response.BannerResponse;

@Service
public class BannerClient {

	@Autowired
	AddressRepository addressRepository;

	private String bannerServiceUrl = "http://localhost:8082/banners";
	
	public void saveBanner(AdvertRequest advertRequest) {

		BannerRequest bannerRequest = new BannerRequest();
		bannerRequest.setAdvertId(advertRequest.getAdvertId());
		bannerRequest.setPhone(advertRequest.getPhone());
		bannerRequest.setTotal(advertRequest.getTotal());
		bannerRequest.setAddressId(advertRequest.getAddressId());

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<BannerResponse> response = restTemplate.postForEntity(bannerServiceUrl, bannerRequest, BannerResponse.class);
		System.out.println(response.toString());
		
		if (response.getStatusCode() == HttpStatus.OK) {
			System.out.println(response.getBody().toString());
		} else {
			System.out.println("Banner Service Status Code: "  + response.getStatusCode());
		}
	}

	/*
	private BannerRequest prepareSaveBannerRequest() {
		BannerRequest request = new BannerRequest();
		request.setAdvertId(1);
		request.setPhone("555 44 33");
		request.setTotal(1);
		request.setAddressId(3);
		return request;
	}

	 */

}
