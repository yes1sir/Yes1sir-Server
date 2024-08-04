package yes1sir.yessir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yes1sir.yessir.model.Product;
import yes1sir.yessir.model.SkinType;
import yes1sir.yessir.repository.ProductRepository;
import yes1sir.yessir.repository.SkinTypeRepository;

import jakarta.annotation.PostConstruct;

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
        saveSkinType("DRPT");
        saveSkinType("DRNT");
        saveSkinType("DSPT");
        saveSkinType("DSNT");
        saveSkinType("DRPW");
        saveSkinType("DRNW");
        saveSkinType("DSPW");
        saveSkinType("DSNW");
        saveSkinType("ORPT");
        saveSkinType("ORNT");
        saveSkinType("OSPT");
        saveSkinType("OSNT");
        saveSkinType("ORPW");
        saveSkinType("ORNW");
        saveSkinType("OSPW");
        saveSkinType("OSNW");

        // 제품 정보 저장
        saveProduct("원오브뎀", "[키링증정] 원오브뎀 드 뗑 쿠션 12g 2종 택 1", "DRPT", 23600, "여드름 억제, 반점 제거", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020657314ko.jpg?l=ko");
        saveProduct("우르오스", "[옥택연Pick]우르오스 스킨워시 500ml 단품/기획(+메쉬파우치)", "ORNT", 15700, "여드름 억제, 모공 청소, 반점 제거", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020580213ko.jpg?l=ko");
        saveProduct("아이디얼포맨", "[콜라겐]아이디얼 포 맨 퍼펙트 올인원 기획 2024 AD(150mL+30mL)", "DRNT", 22500, "반점 제거, 모공 청소, 주름 제거, 탄력 증진", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0020/A00000020787604ko.jpg?l=ko");
        saveProduct("라운드랩", "[민감진정] 라운드랩 포 맨 소나무 진정 토너/로션 2종 세트(+클렌저 40ml 증정)", "ORPT", 32000, "질감 개선, 주름 제거, 반점 제거", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0019/A00000019915608ko.jpg?l=ko");
        saveProduct("라운드랩", "[고민진정] 라운드랩 포 맨 소나무 진정 시카 토너 200ml", "DSPT", 18500, "모공 청소, 주름 제거", "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0019/A00000019915301ko.jpg?l=ko");
        // 추가적인 제품 정보는 같은 형식으로 계속 삽입...
    }

    private void saveSkinType(String typeName) {
        SkinType skinType = new SkinType();
        skinType.setTypeName(typeName);
        skinTypeRepository.save(skinType);
    }

    private void saveProduct(String brandName, String productName, String recommendedType, double price, String purpose, String image) {
        Product product = new Product();
        product.setBrandName(brandName);
        product.setProductName(productName);
        product.setRecommendedType(recommendedType);
        product.setPrice(price);
        product.setPurpose(purpose);
        product.setImage(image);
        productRepository.save(product);
    }
}
