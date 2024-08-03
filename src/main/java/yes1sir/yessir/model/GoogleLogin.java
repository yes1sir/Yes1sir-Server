package yes1sir.yessir.model;

import jakarta.persistence.*;

@Entity
@Table(name = "google_login")
public class GoogleLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "googleid", nullable = false)
    private Long googleId;

    @Column(name = "userid", nullable = false)
    private Long userId;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoogleId() {
        return googleId;
    }

    public void setGoogleId(Long googleId) {
        this.googleId = googleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
