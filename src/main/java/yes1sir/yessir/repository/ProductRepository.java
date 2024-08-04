package yes1sir.yessir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yes1sir.yessir.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByRecommendedType(String recommendedType);
}