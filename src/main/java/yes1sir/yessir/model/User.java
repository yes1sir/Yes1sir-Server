package yes1sir.yessir.model;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @Column(nullable = true, length = 255)
    private String email;

    @Column(nullable = true)
    private Long googleID;

    @Column(nullable = true)
    private Long skinTypeID;

    // Getters and setters
    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getGoogleID() {
        return googleID;
    }

    public void setGoogleID(Long googleID) {
        this.googleID = googleID;
    }

    public Long getSkinTypeID() {
        return skinTypeID;
    }

    public void setSkinTypeID(Long skinTypeID) {
        this.skinTypeID = skinTypeID;
    }
}
