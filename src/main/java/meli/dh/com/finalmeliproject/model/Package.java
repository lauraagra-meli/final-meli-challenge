package meli.dh.com.finalmeliproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String packageType;

    @Column(nullable = false)
    private int storageCapacity;

    @ManyToOne
    @JsonIgnoreProperties("package")
    @JoinColumn(name = "id_category")
    private Category category;
}
