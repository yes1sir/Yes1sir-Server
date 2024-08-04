package yes1sir.yessir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yes1sir.yessir.model.Product;
import yes1sir.yessir.model.SkinType;
import yes1sir.yessir.repository.ProductRepository;
import yes1sir.yessir.repository.SkinTypeRepository;

import jakarta.annotation.PostConstruct;
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
        SkinType DRPT = saveSkinType("DRPT");
        SkinType DRNT = saveSkinType("DRNT");
        SkinType DSPT = saveSkinType("DSPT");
        SkinType DSNT = saveSkinType("DSNT");
        SkinType DRPW = saveSkinType("DRPW");
        SkinType DRNW = saveSkinType("DRNW");
        SkinType DSPW = saveSkinType("DSPW");
        SkinType DSNW = saveSkinType("DSNW");
        SkinType ORPT = saveSkinType("ORPT");
        SkinType ORNT = saveSkinType("ORNT");
        SkinType OSPT = saveSkinType("OSPT");
        SkinType OSNT = saveSkinType("OSNT");
        SkinType ORPW = saveSkinType("ORPW");
        SkinType ORNW = saveSkinType("ORNW");
        SkinType OSPW = saveSkinType("OSPW");
        SkinType OSNW = saveSkinType("OSNW");

        // 제품 정보 저장
        Set<SkinType> recommendedTypes1 = new HashSet<>();
        recommendedTypes1.add(OSPT);
        recommendedTypes1.add(OSPW);
        saveProduct("원오브뎀", "[키링증정] 원오브뎀 드 뗑 쿠션 12g 2종 택 1", recommendedTypes1, 23600, "여드름 억제, 반점 제거", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020657314ko.jpg?l=ko");

        Set<SkinType> recommendedTypes2 = new HashSet<>();
        recommendedTypes2.add(ORNT);
        saveProduct("우르오스", "[옥택연Pick]우르오스 스킨워시 500ml 단품/기획(+메쉬파우치)", recommendedTypes2, 15700, "여드름 억제, 모공 청소, 반점 제거", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020580213ko.jpg?l=ko");

        Set<SkinType> recommendedTypes3 = new HashSet<>();
        recommendedTypes3.add(DRNT);
        saveProduct("아이디얼포맨", "[콜라겐]아이디얼 포 맨 퍼펙트 올인원 기획 2024 AD(150mL+30mL)", recommendedTypes3, 22500, "반점 제거, 모공 청소, 주름 제거, 탄력 증진", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020787604ko.jpg?l=ko");

        // 추가적인 제품 정보는 같은 형식으로 계속 삽입...
    }

    private SkinType saveSkinType(String typeName) {
        SkinType skinType = new SkinType();
        skinType.setTypeName(typeName);
        return skinTypeRepository.save(skinType);
    }

    private void saveProduct(String brandName, String productName, Set<SkinType> recommendedTypes, double price, String purpose, String image) {
        Product product = new Product();
        product.setBrandName(brandName);
        product.setProductName(productName);
        product.setRecommendedTypes(recommendedTypes);
        product.setPrice(price);
        product.setPurpose(purpose);
        product.setImage(image);
        productRepository.save(product);
    }
}
