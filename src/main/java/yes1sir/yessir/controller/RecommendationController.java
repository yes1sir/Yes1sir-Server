package yes1sir.yessir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yes1sir.yessir.model.Product;
import yes1sir.yessir.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class RecommendationController {

    private final ProductService productService;

    @Autowired
    public RecommendationController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/recommendations/{skinType}")
    public List<Product> getRecommendations(@PathVariable String skinType) {
        return productService.recommendProducts(skinType);
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
}
