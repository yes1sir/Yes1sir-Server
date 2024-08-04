package yes1sir.yessir.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String name;
    private String imageUrl;
    private double price;
    private String recommendedType; // Ensure this field exists in your model
    private String benefits;


    @ManyToMany
    @JoinTable(
            name = "product_skin_type",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "skin_type_id")
    )
    private Set<SkinType> applicableSkinTypes;

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRecommendedType() {
        return recommendedType;
    }

    public void setRecommendedType(String recommendedType) {
        this.recommendedType = recommendedType;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public Set<SkinType> getApplicableSkinTypes() {
        return applicableSkinTypes;
    }

    public void setApplicableSkinTypes(Set<SkinType> applicableSkinTypes) {
        this.applicableSkinTypes = applicableSkinTypes;
    }

}
