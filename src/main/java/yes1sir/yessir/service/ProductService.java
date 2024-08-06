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
        // 여기에 적절한 로직을 추가하십시오
        return productRepository.findByApplicableSkinTypes_TypeName(skinTypeId);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
}
