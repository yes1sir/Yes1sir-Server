package yes1sir.yessir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yes1sir.yessir.dto.ProductResponseDTO;
import yes1sir.yessir.model.Product;
import yes1sir.yessir.model.SkinType;
import yes1sir.yessir.service.ProductService;
import yes1sir.yessir.service.SkinTypeService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final SkinTypeService skinTypeService;
    private final ProductService productService;

    @Autowired
    public RecommendationController(SkinTypeService skinTypeService, ProductService productService) {
        this.skinTypeService = skinTypeService;
        this.productService = productService;
    }

    @GetMapping("/{skinTypeName}")
    public List<ProductResponseDTO> getRecommendationsBySkinType(@PathVariable String skinTypeName) {
        Optional<SkinType> skinType = skinTypeService.getSkinTypeByTypeName(skinTypeName);
        if (skinType.isPresent()) {
            List<Product> products = productService.getProductsBySkinType(skinType.get());
            return products.stream().map(product -> new ProductResponseDTO(
                    product.getProductName(),
                    product.getBrandName(),
                    product.getRecommendedType(),
                    product.getApplicableSkinTypes().stream()
                            .map(SkinType::getTypeName)
                            .collect(Collectors.joining(", ")),
                    product.getPrice().doubleValue(),
                    product.getPurpose(),
                    product.getImage()
            )).collect(Collectors.toList());
        } else {
            return null;  // 또는 적절한 에러 처리를 추가할 수 있습니다.
        }
    }
}
