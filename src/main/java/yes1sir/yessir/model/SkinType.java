package yes1sir.yessir.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class SkinType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeName;

    @ManyToMany(mappedBy = "recommendedTypes")
    private Set<Product> products;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    // 추가된 메서드들
    public Long getSkinTypeID() {
        return this.id;
    }

    public String getSkinTypeName() {
        return this.typeName;
    }

    public String getDescription() {
        return "Description for " + this.typeName; // 필요에 따라 설명을 다르게 설정할 수 있습니다.
    }
}
