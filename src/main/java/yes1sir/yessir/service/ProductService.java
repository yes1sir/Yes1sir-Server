package yes1sir.yessir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yes1sir.yessir.model.Product;
import yes1sir.yessir.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> recommendProducts(String skinTypeId) {
        return productRepository.findByApplicableSkinTypes_TypeName(skinTypeId);
    }

    // 새로운 메서드 추가
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
}
