package yes1sir.yessir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yes1sir.yessir.model.Product;
import yes1sir.yessir.model.SkinType;
import yes1sir.yessir.repository.ProductRepository;
import yes1sir.yessir.repository.SkinTypeRepository;

import jakarta.annotation.PostConstruct;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Service
public class DataInitializationService {

    private final ProductRepository productRepository;
    private final SkinTypeRepository skinTypeRepository;

    @Autowired
    public DataInitializationService(ProductRepository productRepository, SkinTypeRepository skinTypeRepository) {
        this.productRepository = productRepository;
        this.skinTypeRepository = skinTypeRepository;
    }

    @PostConstruct
    public void init() {
        // 피부 유형 저장
        SkinType DRPT = new SkinType();
        DRPT.setTypeName("DRPT");
        skinTypeRepository.save(DRPT);

        SkinType OSPT = new SkinType();
        OSPT.setTypeName("OSPT");
        skinTypeRepository.save(OSPT);

        // 더 많은 피부 유형 저장 코드 생략

        // 제품 저장
        Set<SkinType> applicableSkinTypes1 = new HashSet<>();
        applicableSkinTypes1.add(OSPT);
        applicableSkinTypes1.add(DRPT);

        Product product1 = new Product();
        product1.setProductName("[키링증정] 원오브뎀 드 뎀 쿠션 12g 2종 택 1");
        product1.setBrandName("원오브뎀");
        product1.setRecommendedType("O, S");
        product1.setApplicableSkinTypes(applicableSkinTypes1);
        product1.setPrice(new BigDecimal(23600));
        product1.setPurpose("여드름 억제, 반점 제거");
        product1.setImage("https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020657314ko.jpg?l=ko");

        productRepository.save(product1);

        // 더 많은 제품 저장 코드 생략
    }
}
