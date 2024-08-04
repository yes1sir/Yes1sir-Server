package yes1sir.yessir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yes1sir.yessir.model.Product;
import yes1sir.yessir.model.SkinType;
import yes1sir.yessir.service.ProductService;
import yes1sir.yessir.service.SkinTypeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RecommendationController {

    private final SkinTypeService skinTypeService;
    private final ProductService productService;

    @Autowired
    public RecommendationController(SkinTypeService skinTypeService, ProductService productService) {
        this.skinTypeService = skinTypeService;
        this.productService = productService;
    }

    @GetMapping("/{typeName}")
    public List<Product> getRecommendationsBySkinType(@PathVariable String typeName) {
        Optional<SkinType> skinType = skinTypeService.getSkinTypeByTypeName(typeName);
        return skinType.map(productService::getProductsBySkinType).orElse(null); // 적절한 에러 처리를 추가할 수 있습니다.
    }
}
