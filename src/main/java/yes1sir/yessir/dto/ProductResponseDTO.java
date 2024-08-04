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

    // Getters and setters

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getRecommendedType() {
        return recommendedType;
    }

    public void setRecommendedType(String recommendedType) {
        this.recommendedType = recommendedType;
    }

    public String getApplicableTypes() {
        return applicableTypes;
    }

    public void setApplicableTypes(String applicableTypes) {
        this.applicableTypes = applicableTypes;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
