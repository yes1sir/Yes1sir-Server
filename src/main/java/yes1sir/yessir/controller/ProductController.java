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
                    product.getBenefits(),
                    product.getPrice(),
                    product.getImageUrl()
            );
            return ResponseEntity.ok(productResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"detail\": \"제품을 찾을 수 없습니다.\"}");
        }
    }

    public static class ProductResponse {
        private String name;
        private String brand;
        private String benefits;
        private String price; // 가격을 String 타입으로 변경
        private String imageUrl;

        public ProductResponse(String name, String brand, String benefits, BigDecimal price, String imageUrl) {
            this.name = name;
            this.brand = brand;
            this.benefits = benefits;
            this.price = price.stripTrailingZeros().toPlainString(); // 가격 변환 시 소수점 제거
            this.imageUrl = imageUrl;
        }

        // Getters
        public String getName() {
            return name;
        }

        public String getBrand() {
            return brand;
        }

        public String getBenefits() {
            return benefits;
        }

        public String getPrice() {
            return price;
        }

        public String getImageUrl() {
            return imageUrl;
        }
    }
}
