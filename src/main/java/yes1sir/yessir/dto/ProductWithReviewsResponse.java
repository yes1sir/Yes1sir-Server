package yes1sir.yessir.dto;

import java.util.List;
import java.util.Set;

public class ProductWithReviewsResponse {
    private Long productId;
    private String brand;
    private String name;
    private String imageUrl;
    private int price;  // int로 변경
    private String recommendedType;
    private String benefits;
    private Set<String> applicableSkinTypes;
    private List<ReviewResponse> reviews;

    public ProductWithReviewsResponse(Long productId, String brand, String name, String imageUrl, double price, String recommendedType, String benefits, Set<String> applicableSkinTypes, List<ReviewResponse> reviews) {
        this.productId = productId;
        this.brand = brand;
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = (int) price;  // 소수점 이하를 제거
        this.recommendedType = recommendedType;
        this.benefits = benefits;
        this.applicableSkinTypes = applicableSkinTypes;
        this.reviews = reviews;
    }

    // Getters and setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = (int) price;
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

    public Set<String> getApplicableSkinTypes() {
        return applicableSkinTypes;
    }

    public void setApplicableSkinTypes(Set<String> applicableSkinTypes) {
        this.applicableSkinTypes = applicableSkinTypes;
    }

    public List<ReviewResponse> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewResponse> reviews) {
        this.reviews = reviews;
    }
}
