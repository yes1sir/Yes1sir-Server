package yes1sir.yessir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yes1sir.yessir.model.Product;
import yes1sir.yessir.service.ProductService;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable Long productId) {
        Optional<Product> productOpt = productService.getProductById(productId);
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            ProductResponse productResponse = new ProductResponse(
                    product.getName(),
                    product.getBrand(),
                    product.getSkinTypes(),
                    product.getPrice(),
                    product.getBenefits(),
                    product.getImageUrl()
            );
            return ResponseEntity.ok(productResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"detail\": \"제품을 찾을 수 없습니다.\"}");
        }
    }

    // 내부 클래스 또는 별도의 파일로 응답 데이터 구조 정의
    public static class ProductResponse {
        private String productName;
        private String brandName;
        private String recommendedType;
        private BigDecimal price;
        private String purpose;
        private String image;

        public ProductResponse(String productName, String brandName, String recommendedType, BigDecimal price, String purpose, String image) {
            this.productName = productName;
            this.brandName = brandName;
            this.recommendedType = recommendedType;
            this.price = price;
            this.purpose = purpose;
            this.image = image;
        }

        // Getters
        public String getProductName() {
            return productName;
        }

        public String getBrandName() {
            return brandName;
        }

        public String getRecommendedType() {
            return recommendedType;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public String getPurpose() {
            return purpose;
        }

        public String getImage() {
            return image;
        }
    }
}
