package yes1sir.yessir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yes1sir.yessir.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByApplicableSkinTypes_TypeName(String typeName);

    boolean existsByBrandAndName(String brand, String name);

    // 새로운 메서드 추가
    Optional<Product> findById(Long id);
}
