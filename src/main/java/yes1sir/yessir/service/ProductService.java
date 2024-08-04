package yes1sir.yessir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yes1sir.yessir.model.Product;
import yes1sir.yessir.model.SkinType;
import yes1sir.yessir.repository.ProductRepository;
import yes1sir.yessir.repository.SkinTypeRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final SkinTypeRepository skinTypeRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, SkinTypeRepository skinTypeRepository) {
        this.productRepository = productRepository;
        this.skinTypeRepository = skinTypeRepository;
    }

    public List<Product> getProductsBySkinTypeId(Long skinTypeId) {
        SkinType skinType = skinTypeRepository.findById(skinTypeId).orElseThrow();
        return productRepository.findByApplicableSkinTypesContaining(skinType);
    }
}
