package emlakburada.Repository;

import emlakburada.dto.EmailMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailMessage, Integer> {
}
