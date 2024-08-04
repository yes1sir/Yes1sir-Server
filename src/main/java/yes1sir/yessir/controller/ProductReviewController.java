package yes1sir.yessir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yes1sir.yessir.model.Product;
import yes1sir.yessir.model.ProductReview;
import yes1sir.yessir.repository.ProductRepository;
import yes1sir.yessir.service.ProductReviewService;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductReviewController {

    private final ProductReviewService productReviewService;
    private final ProductRepository productRepository;

    @Autowired
    public ProductReviewController(ProductReviewService productReviewService, ProductRepository productRepository) {
        this.productReviewService = productReviewService;
        this.productRepository = productRepository;
    }

    @PostMapping("/{productId}/reviews")
    public ResponseEntity<?> createReview(@PathVariable Long productId, @RequestBody ProductReview review) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            review.setProduct(product.get());
            review.setReviewDate(LocalDateTime.now());
            ProductReview savedReview = productReviewService.createReview(review);
            return ResponseEntity.ok(savedReview);
        } else {
            return ResponseEntity.status(404).body("{\"detail\":\"제품을 찾을 수 없습니다.\"}");
        }
    }
}
