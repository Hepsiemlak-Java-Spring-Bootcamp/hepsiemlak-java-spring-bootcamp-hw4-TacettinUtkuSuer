package emlakburada.repository;

import emlakburada.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository <Address, Integer> {
}
