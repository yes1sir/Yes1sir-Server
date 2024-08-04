package yes1sir.yessir.dto;

public class ReviewRequest {
    private int rating;
    private String comment;

    // Getters
    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    // Setters
    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
