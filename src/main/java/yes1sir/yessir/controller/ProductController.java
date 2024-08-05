package yes1sir.yessir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yes1sir.yessir.dto.ProductResponseDTO;
import yes1sir.yessir.model.Product;
import yes1sir.yessir.model.SkinType;
import yes1sir.yessir.service.ProductService;

import java.text.DecimalFormat;
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
    public ResponseEntity<?> getProductById(@PathVariable Long productId) {
        Optional<Product> productOpt = productService.getProductById(productId);
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            DecimalFormat decimalFormat = new DecimalFormat("#");

            ProductResponseDTO productResponse = new ProductResponseDTO(
                    String.valueOf(product.getId()), // Long 타입의 ID를 String으로 변환
                    product.getName(),
                    product.getBrand(),
                    product.getRecommendedType(), // recommendedType
                    product.getApplicableSkinTypes().stream()
                            .map(SkinType::getTypeName)
                            .collect(Collectors.joining(", ")), // applicableTypes
                    decimalFormat.format(product.getPrice()), // 소수점 없이 문자열로 반환
                    product.getImageUrl(),
                    product.getBenefits() // purpose
            );
            return ResponseEntity.ok(productResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"detail\": \"제품을 찾을 수 없습니다.\"}");
        }
    }
}
