package yes1sir.yessir.model;

import jakarta.persistence.*;
import java.util.Set;
import java.math.BigDecimal;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private String benefits;
    private String imageUrl;
    private BigDecimal price;

    @ManyToMany
    @JoinTable(
            name = "product_skin_types",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "skin_type_id")
    )
    private Set<SkinType> applicableSkinTypes;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<SkinType> getApplicableSkinTypes() {
        return applicableSkinTypes;
    }

    public void setApplicableSkinTypes(Set<SkinType> applicableSkinTypes) {
        this.applicableSkinTypes = applicableSkinTypes;
    }

    public void setSuitableFor(Set<SkinType> suitableFor) {
        this.applicableSkinTypes = suitableFor;
    }

    public String getSkinTypes() {
        return applicableSkinTypes.stream()
                .map(SkinType::getTypeName)
                .reduce((first, second) -> first + "," + second)
                .orElse("");
    }

    public void setSkinTypes(String skinTypes) {
        // 이 메서드는 String 타입의 skinTypes를 받아 처리하는 로직을 포함할 수 있습니다.
        // 필요한 경우 적절한 변환 로직을 추가하세요.
    }
}
