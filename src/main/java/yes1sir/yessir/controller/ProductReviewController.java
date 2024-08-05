package yes1sir.yessir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import yes1sir.yessir.dto.ReviewRequest;
import yes1sir.yessir.dto.ReviewResponse;
import yes1sir.yessir.model.ProductReview;
import yes1sir.yessir.service.ProductReviewService;

import java.io.IOException;
import java.time.LocalDateTime;
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
                                          @RequestPart("review") ReviewRequest reviewRequest,
                                          @RequestPart("commentFile") MultipartFile commentFile) {
        ProductReview review = new ProductReview();
        review.setProductId(productId);
        review.setUserName(reviewRequest.getUserName());
        review.setRating(reviewRequest.getRating());

        try {
            review.setComment(new String(commentFile.getBytes()));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"detail\": \"파일 처리 중 오류가 발생했습니다.\"}");
        }

        review.setReviewDate(LocalDateTime.now());

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
                                          @RequestPart("review") ReviewRequest reviewRequest,
                                          @RequestPart("commentFile") MultipartFile commentFile) {
        Optional<ProductReview> reviewOpt = productReviewService.getReviewById(productId, reviewId);

        if (!reviewOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"detail\": \"리뷰를 찾을 수 없습니다.\"}");
        }

        ProductReview review = reviewOpt.get();
        review.setRating(reviewRequest.getRating());

        try {
            review.setComment(new String(commentFile.getBytes()));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"detail\": \"파일 처리 중 오류가 발생했습니다.\"}");
        }

        review.setReviewDate(LocalDateTime.now());

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
