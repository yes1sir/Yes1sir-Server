package yes1sir.yessir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yes1sir.yessir.model.ProductReview;
import yes1sir.yessir.repository.ProductReviewRepository;

@Service
public class ProductReviewService {

    private final ProductReviewRepository productReviewRepository;

    @Autowired
    public ProductReviewService(ProductReviewRepository productReviewRepository) {
        this.productReviewRepository = productReviewRepository;
    }

    public ProductReview createReview(ProductReview review) {
        return productReviewRepository.save(review);
    }
}
