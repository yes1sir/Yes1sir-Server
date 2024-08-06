package yes1sir.yessir.dto;

import java.time.LocalDateTime;

public class ReviewResponse {
    private Long reviewId;
    private Long productId;
    private String userName;
    private int rating;
    private String comment;
    private LocalDateTime reviewDate;

    // Constructor

    public ReviewResponse(Long reviewId, Long productId, String userName, int rating, String comment, LocalDateTime reviewDate) {
        this.reviewId = reviewId;
        this.productId = productId;
        this.userName = userName;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }

    // Getters

    public Long getReviewId() {
        return reviewId;
    }

    public Long getProductId() {
        return productId;
    }

    public String getUserName() {
        return userName;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }
}
