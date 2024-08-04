package yes1sir.yessir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yes1sir.yessir.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
