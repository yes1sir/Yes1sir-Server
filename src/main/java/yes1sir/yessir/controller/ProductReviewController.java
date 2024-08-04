package yes1sir.yessir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.*;
import yes1sir.yessir.dto.ReviewRequest;
import yes1sir.yessir.dto.ReviewResponse;
import yes1sir.yessir.model.ProductReview;
import yes1sir.yessir.service.ProductReviewService;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductReviewController {

    private final ProductReviewService productReviewService;

    @Autowired
    public ProductReviewController(ProductReviewService productReviewService) {
        this.productReviewService = productReviewService;
    }

    @PostMapping("/{productId}/reviews")
    public ResponseEntity<?> createReview(@PathVariable Long productId,
                                          @AuthenticationPrincipal OidcUser oidcUser,
                                          @RequestBody ReviewRequest reviewRequest) {
        if (oidcUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"detail\": \"유저를 찾을 수 없습니다.\"}");
        }

        ProductReview review = new ProductReview();
        review.setProductId(productId);
        review.setUserName(oidcUser.getFullName());
        review.setRating(reviewRequest.getRating());
        review.setComment(reviewRequest.getComment());

        ProductReview savedReview = productReviewService.saveReview(review);

        return ResponseEntity.ok(new ReviewResponse(
                savedReview.getReviewId(),
                savedReview.getProductId(),
                savedReview.getUserName(),
                savedReview.getRating(),
                savedReview.getComment(),
                savedReview.getReviewDate()
        ));
    }

    @PatchMapping("/{productId}/reviews/{reviewId}")
    public ResponseEntity<?> updateReview(@PathVariable Long productId,
                                          @PathVariable Long reviewId,
                                          @RequestBody ReviewRequest reviewRequest) {
        Optional<ProductReview> reviewOpt = productReviewService.getReviewById(productId, reviewId);

        if (!reviewOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"detail\": \"리뷰를 찾을 수 없습니다.\"}");
        }

        ProductReview review = reviewOpt.get();
        review.setRating(reviewRequest.getRating());
        review.setComment(reviewRequest.getComment());

        ProductReview updatedReview = productReviewService.saveReview(review);

        return ResponseEntity.ok(new ReviewResponse(
                updatedReview.getReviewId(),
                updatedReview.getProductId(),
                updatedReview.getUserName(),
                updatedReview.getRating(),
                updatedReview.getComment(),
                updatedReview.getReviewDate()
        ));
    }

    @GetMapping("/{productId}/reviews/{reviewId}")
    public ResponseEntity<?> getReviewById(@PathVariable Long productId, @PathVariable Long reviewId) {
        Optional<ProductReview> reviewOpt = productReviewService.getReviewById(productId, reviewId);

        if (!reviewOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"detail\": \"리뷰를 찾을 수 없습니다.\"}");
        }

        ProductReview review = reviewOpt.get();
        ReviewResponse response = new ReviewResponse(
                review.getReviewId(),
                review.getProductId(),
                review.getUserName(),
                review.getRating(),
                review.getComment(),
                review.getReviewDate()
        );

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{productId}/reviews/{reviewId}")
    public ResponseEntity<?> deleteReview(@PathVariable Long productId, @PathVariable Long reviewId) {
        Optional<ProductReview> reviewOpt = productReviewService.getReviewById(productId, reviewId);

        if (!reviewOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"message\": \"리뷰를 찾을 수 없습니다.\"}");
        }

        productReviewService.deleteReview(reviewId);

        return ResponseEntity.ok("{\"message\": \"리뷰가 성공적으로 삭제되었습니다.\"}");
    }
}
