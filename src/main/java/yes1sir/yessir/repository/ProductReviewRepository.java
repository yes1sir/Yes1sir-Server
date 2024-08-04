package yes1sir.yessir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yes1sir.yessir.model.ProductReview;

import java.util.Optional;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {
    Optional<ProductReview> findByProductIdAndReviewId(Long productId, Long reviewId);
}
