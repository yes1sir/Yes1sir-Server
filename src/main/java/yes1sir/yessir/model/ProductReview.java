package yes1sir.yessir.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private String comment;
    private int rating;
    private LocalDateTime reviewDate;
    private Long userId;

    @ManyToOne
    private Product product;

    // 기본 생성자
    public ProductReview() {
    }

    // 매개변수를 받는 생성자
    public ProductReview(String comment, int rating, LocalDateTime reviewDate, Long userId, Product product) {
        this.comment = comment;
        this.rating = rating;
        this.reviewDate = reviewDate;
        this.userId = userId;
        this.product = product;
    }

    // Getter와 Setter 메소드
    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDateTime reviewDate) {
        this.reviewDate = reviewDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductReview{" +
                "reviewId=" + reviewId +
                ", comment='" + comment + '\'' +
                ", rating=" + rating +
                ", reviewDate=" + reviewDate +
                ", userId=" + userId +
                ", product=" + product +
                '}';
    }
}
