package yes1sir.yessir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yes1sir.yessir.model.GoogleLogin;

import java.util.Optional;

public interface GoogleLoginRepository extends JpaRepository<GoogleLogin, Long> {
    Optional<GoogleLogin> findByGoogleId(Long googleId); // googleID -> googleId로 수정
}
