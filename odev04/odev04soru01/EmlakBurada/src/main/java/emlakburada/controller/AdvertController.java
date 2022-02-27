package emlakburada.controller;

import java.util.List;

import emlakburada.client.BannerClient;
import emlakburada.model.Message;
import emlakburada.queue.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import emlakburada.dto.request.AdvertRequest;
import emlakburada.dto.response.AdvertResponse;
import emlakburada.service.AdvertService;

@RestController
public class AdvertController {

	@Autowired
	private AdvertService advertService;

	@Autowired
	private BannerClient bannerClient;

	@GetMapping(value = "/adverts")
	public ResponseEntity<List<AdvertResponse>> getAllAdvert() {
		return new ResponseEntity<>(advertService.getAllAdverts(), HttpStatus.OK);
	}

	@PostMapping(value = "/adverts")
	public ResponseEntity<AdvertResponse> createAdvert(@RequestBody AdvertRequest request) {
		bannerClient.saveBanner(request);
		return new ResponseEntity<>(advertService.saveAdvert(request), HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/adverts/{advertNo}")
	public ResponseEntity<AdvertResponse> deleteAdvertByAdvertId(@PathVariable(required = false) int advertNo) {
		advertService.deleteAdvertByAdvertId(advertNo);
		return new ResponseEntity<>(HttpStatus.OK);
	}



}
