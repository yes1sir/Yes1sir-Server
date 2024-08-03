package yes1sir.yessir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yes1sir.yessir.model.GoogleLogin;

public interface GoogleLoginRepository extends JpaRepository<GoogleLogin, Long> {
}
