package yes1sir.yessir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import yes1sir.yessir.dto.ProductResponseDTO;
import yes1sir.yessir.model.Product;
import yes1sir.yessir.model.SkinType;
import yes1sir.yessir.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RecommendationController {

    private final ProductService productService;

    @Autowired
    public RecommendationController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/recommendations/{skinTypeId}")
    public List<ProductResponseDTO> recommendProducts(@PathVariable String skinTypeId) {
        List<Product> products = productService.recommendProducts(skinTypeId);
        return products.stream()
                .map(product -> new ProductResponseDTO(
                        String.valueOf(product.getId()), // Long 타입의 ID를 String으로 변환
                        product.getName(),
                        product.getBrand(),
                        product.getRecommendedType(), // recommendedType
                        product.getApplicableSkinTypes().stream()
                                .map(SkinType::getTypeName)
                                .collect(Collectors.joining(", ")), // applicableTypes
                        String.valueOf(product.getPrice().intValue()), // 소수점 없이 문자열로 반환
                        product.getImageUrl(),
                        product.getBenefits() // purpose
                ))
                .toList();
    }
}
