package yes1sir.yessir.dto;

public class ProductResponseDTO {
    private String productId;
    private String productName;
    private String brandName;
    private String recommendedType;
    private String applicableTypes;
    private String price;
    private String image;
    private String purpose;

    public ProductResponseDTO(String productId, String productName, String brandName, String recommendedType, String applicableTypes, String price, String image, String purpose) {
        this.productId = productId;
        this.productName = productName;
        this.brandName = brandName;
        this.recommendedType = recommendedType;
        this.applicableTypes = applicableTypes;
        this.price = price;
        this.image = image;
        this.purpose = purpose;
    }

    // Getters
    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getRecommendedType() {
        return recommendedType;
    }

    public String getApplicableTypes() {
        return applicableTypes;
    }

    public String getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public String getPurpose() {
        return purpose;
    }
}
