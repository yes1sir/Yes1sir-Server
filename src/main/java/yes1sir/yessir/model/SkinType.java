package yes1sir.yessir.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SkinType")
@Getter
@Setter
public class SkinType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skinTypeID;
    private String skinTypeName;
    private String description;
}
