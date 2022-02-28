package emlakburada.service;

import java.util.ArrayList;
import java.util.List;

import emlakburada.repository.BannerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakburada.dto.request.BannerRequest;
import emlakburada.dto.response.BannerResponse;
import emlakburada.model.Banner;
import emlakburada.repository.BannerLocalRepository;

@Service
@Slf4j
public class BannerService {

	@Autowired
	private BannerLocalRepository bannerRepository;

	@Autowired
	private BannerRepository bannerDBRepository;


	public List<BannerResponse> getAllBanners() {
		List<BannerResponse> bannerResponses = new ArrayList<>();
		for (Banner banner : bannerRepository.findAllBanners()) {
			bannerResponses.add(convertToBannerResponse(banner));
		}
		return bannerResponses;
	}


	public BannerResponse saveBanner(BannerRequest request) {
		 Banner banner = bannerRepository.saveBanner(convertToBanner(request));
		return convertToBannerResponse(banner);
	}


	public void saveBannerToDB(BannerRequest request){
		try {

			bannerDBRepository.save(convertToBanner(request));

		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	private BannerResponse convertToBannerResponse(Banner banner) {
		BannerResponse response = new BannerResponse();
		response.setAdvertId(banner.getAdvertId());
		response.setPhone(banner.getPhone());
		response.setTotal(banner.getTotal());
		response.setBannerId(banner.getBannerId());
		response.setAddressId(banner.getAddressId());
		return response;
	}

	private Banner convertToBanner(BannerRequest request) {
		Banner banner = new Banner();
		banner.setAdvertId(request.getAdvertId());
		banner.setPhone(request.getPhone());
		banner.setAddressId(request.getAddressId());
		banner.setTotal(request.getTotal());
		return banner;
	}

}
