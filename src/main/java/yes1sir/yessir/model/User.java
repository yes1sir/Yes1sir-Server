package yes1sir.yessir.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "googleid", nullable = false)
    private Long googleId; // googleID -> googleId로 수정

    @ManyToOne
    @JoinColumn(name = "skin_type_skin_typeid")
    private SkinType skinType;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getGoogleId() {
        return googleId;
    }

    public void setGoogleId(Long googleId) {
        this.googleId = googleId;
    }

    public SkinType getSkinType() {
        return skinType;
    }

    public void setSkinType(SkinType skinType) {
        this.skinType = skinType;
    }

    public Long getUserID() {
        return id;
    }
}
