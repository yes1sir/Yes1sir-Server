package yes1sir.yessir.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "User")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String name;

    @ManyToOne
    @JoinColumn(name = "skinTypeID")
    private SkinType skinType;

    @OneToMany(mappedBy = "user")
    private List<SkinDiagnosis> skinDiagnoses;
}
