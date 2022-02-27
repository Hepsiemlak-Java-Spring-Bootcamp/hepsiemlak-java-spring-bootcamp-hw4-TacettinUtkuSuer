package emlakburada.repository;

import emlakburada.dto.request.BannerRequest;
import emlakburada.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerRepository extends JpaRepository<Banner, Integer> {
}
