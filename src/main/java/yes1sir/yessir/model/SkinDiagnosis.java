package yes1sir.yessir.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "SkinDiagnosis")
@Getter
@Setter
public class SkinDiagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diagnosisID;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "skinTypeID")
    private SkinType skinType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date diagnosisDate;
}
