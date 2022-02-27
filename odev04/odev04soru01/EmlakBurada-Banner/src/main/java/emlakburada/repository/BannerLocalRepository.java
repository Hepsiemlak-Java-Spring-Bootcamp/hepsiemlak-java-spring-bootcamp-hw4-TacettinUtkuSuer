package emlakburada.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emlakburada.model.Banner;

@Repository
public class BannerLocalRepository {


	private List<Banner> banners = new ArrayList<>();

	public List<Banner> findAllBanners() {
		return banners;
	}

	public Banner saveBanner(Banner banner) {
		banners.add(banner);
		return banner;
	}



}
