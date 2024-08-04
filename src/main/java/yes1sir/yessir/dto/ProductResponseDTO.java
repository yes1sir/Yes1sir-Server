package yes1sir.yessir.dto;

public class ProductResponseDTO {
    private String productName;
    private String brandName;
    private String recommendedType;
    private String applicableTypes;
    private double price;
    private String purpose;
    private String image;

    public ProductResponseDTO(String productName, String brandName, String recommendedType, String applicableTypes, double price, String purpose, String image) {
        this.productName = productName;
        this.brandName = brandName;
        this.recommendedType = recommendedType;
        this.applicableTypes = applicableTypes;
        this.price = price;
        this.purpose = purpose;
        this.image = image;
    }

    // Getters and setters

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
