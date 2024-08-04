package yes1sir.yessir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yes1sir.yessir.model.Product;
import yes1sir.yessir.model.SkinType;
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
            return ResponseEntity.noContent().build();
        } else {
            List<ProductResponse> response = products.stream()
                    .map(product -> new ProductResponse(
                            product.getBrandName(),
                            product.getProductName(),
                            product.getRecommendedType(),
                            product.getApplicableSkinTypes().stream().map(SkinType::getTypeName).collect(Collectors.joining(", ")),
                            product.getPrice(),
                            product.getPurpose(),
                            product.getImage()
                    ))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(response);
        }
    }

    static class ProductResponse {
        private String brandName;
        private String productName;
        private String recommendedType;
        private String applicableTypes;
        private double price;
        private String purpose;
        private String image;

        public ProductResponse(String brandName, String productName, String recommendedType, String applicableTypes, double price, String purpose, String image) {
            this.brandName = brandName;
            this.productName = productName;
            this.recommendedType = recommendedType;
            this.applicableTypes = applicableTypes;
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

        public String getApplicableTypes() {
            return applicableTypes;
        }

        public void setApplicableTypes(String applicableTypes) {
            this.applicableTypes = applicableTypes;
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
}
