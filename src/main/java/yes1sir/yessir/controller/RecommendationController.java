package yes1sir.yessir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import yes1sir.yessir.dto.ProductResponseDTO;
import yes1sir.yessir.model.Product;
import yes1sir.yessir.service.ProductService;

import java.util.List;

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
                        product.getName(),
                        product.getBrand(),
                        product.getSkinTypes().toString(),  // 수정된 부분
                        product.getBenefits(),
                        product.getPrice().doubleValue(),  // 수정된 부분
                        product.getImageUrl()  // 수정된 부분
                ))
                .toList();
    }
}
