package yes1sir.yessir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yes1sir.yessir.dto.ProductWithReviewsResponse;
import yes1sir.yessir.dto.ReviewResponse;
import yes1sir.yessir.model.Product;
import yes1sir.yessir.model.SkinType;
import yes1sir.yessir.service.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> getProductWithReviews(@PathVariable Long productId) {
        Optional<Product> productOpt = productService.getProductById(productId);

        if (!productOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"detail\": \"제품을 찾을 수 없습니다.\"}");
        }

        Product product = productOpt.get();
        List<ReviewResponse> reviews = product.getReviews().stream()
                .map(review -> new ReviewResponse(
                        review.getReviewId(),
                        review.getProductId(),
                        review.getUserName(),
                        review.getRating(),
                        review.getComments(),
                        review.getReviewDate()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(new ProductWithReviewsResponse(
                product.getId(),
                product.getBrand(),
                product.getName(),
                product.getImageUrl(),
                product.getPrice(),
                product.getRecommendedType(),
                product.getBenefits(),
                product.getApplicableSkinTypes().stream().map(SkinType::getTypeName).collect(Collectors.toSet()),
                reviews));
    }
}
