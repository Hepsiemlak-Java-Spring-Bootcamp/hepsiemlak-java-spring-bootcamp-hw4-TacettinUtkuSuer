package emlakburada.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import emlakburada.dto.request.BannerRequest;
import emlakburada.dto.response.BannerResponse;
import emlakburada.service.BannerService;

@RestController
public class BannerController {

	@Autowired
	private BannerService bannerService;

	@GetMapping(value = "/banners")
	public ResponseEntity<List<BannerResponse>> getAllBanners() {
		return new ResponseEntity<>(bannerService.getAllBanners(), HttpStatus.OK);
	}

	@PostMapping(value = "/banners")
	public ResponseEntity saveBanner(@RequestBody BannerRequest request) {
		bannerService.saveBannerToDB(request);
		return new ResponseEntity<>(bannerService.saveBanner(request), HttpStatus.OK);
	}

}
