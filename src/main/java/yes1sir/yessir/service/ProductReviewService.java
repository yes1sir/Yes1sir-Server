package yes1sir.yessir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yes1sir.yessir.model.ProductReview;
import yes1sir.yessir.repository.ProductReviewRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ProductReviewService {
    private final ProductReviewRepository productReviewRepository;

    @Autowired
    public ProductReviewService(ProductReviewRepository productReviewRepository) {
        this.productReviewRepository = productReviewRepository;
    }

    public ProductReview saveReview(ProductReview review) {
        review.setReviewDate(LocalDateTime.now());
        return productReviewRepository.save(review);
    }

    public Optional<ProductReview> getReviewById(Long productId, Long reviewId) {
        return productReviewRepository.findByProductIdAndReviewId(productId, reviewId);
    }

    public void deleteReview(Long reviewId) {
        productReviewRepository.deleteById(reviewId);
    }
}
