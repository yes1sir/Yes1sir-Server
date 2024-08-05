package yes1sir.yessir.dto;

public class ReviewRequest {
    private String userName;
    private int rating;
    private String comment;

    // Getters
    public String getUserName() {
        return userName;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    // Setters
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
