package yes1sir.yessir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yes1sir.yessir.model.ProductReview;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {
}
