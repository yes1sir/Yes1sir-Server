package yes1sir.yessir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yes1sir.yessir.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
