package yes1sir.yessir.model;

import jakarta.persistence.*;

@Entity
public class GoogleLogin {

    @Id
    private Long googleID;

    @Column(nullable = false)
    private Long userID;

    // Getters and setters
    public Long getGoogleID() {
        return googleID;
    }

    public void setGoogleID(Long googleID) {
        this.googleID = googleID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
}



