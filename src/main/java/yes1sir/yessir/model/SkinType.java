package yes1sir.yessir.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class SkinType {

    @Id
    private String typeName;

    @ManyToMany(mappedBy = "applicableSkinTypes")
    private Set<Product> products;

    // Getters and setters
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
}
