package yes1sir.yessir.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "GoogleLogin")
@Getter
@Setter
public class GoogleLogin {

    @Id
    private String googleId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
