package yes1sir.yessir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yes1sir.yessir.model.Product;
import yes1sir.yessir.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${app.base.url}/api/recommendations")
public class RecommendationController {

    private final ProductService productService;

    @Autowired
    public RecommendationController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{skinTypeId}")
    public ResponseEntity<?> getRecommendations(@PathVariable Long skinTypeId) {
        List<Product> products = productService.getProductsBySkinTypeId(skinTypeId);
        if (products.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("추천 제품을 찾을 수 없습니다."));
        } else {
            List<ProductRecommendation> recommendations = products.stream()
                    .map(product -> new ProductRecommendation(
                            product.getBrandName(),
                            product.getProductName(),
                            product.getRecommendedType(),
                            product.getPrice(),
                            product.getPurpose(),
                            product.getImage()))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(recommendations);
        }
    }

    static class ProductRecommendation {
        private String brandName;
        private String productName;
        private String recommendedType;
        private double price;
        private String purpose;
        private String image;

        public ProductRecommendation(String brandName, String productName, String recommendedType, double price, String purpose, String image) {
            this.brandName = brandName;
            this.productName = productName;
            this.recommendedType = recommendedType;
            this.price = price;
            this.purpose = purpose;
            this.image = image;
        }

        // Getters and setters
        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getRecommendedType() {
            return recommendedType;
        }

        public void setRecommendedType(String recommendedType) {
            this.recommendedType = recommendedType;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getPurpose() {
            return purpose;
        }

        public void setPurpose(String purpose) {
            this.purpose = purpose;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

    static class ErrorResponse {
        private String detail;

        public ErrorResponse(String detail) {
            this.detail = detail;
        }

        // Getter and setter
        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }
}
