package yes1sir.yessir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yes1sir.yessir.model.SkinType;

import java.util.Optional;

public interface SkinTypeRepository extends JpaRepository<SkinType, Long> {
    Optional<SkinType> findByTypeName(String typeName);
}
