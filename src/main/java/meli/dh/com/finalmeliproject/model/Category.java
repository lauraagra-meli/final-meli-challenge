package meli.dh.com.finalmeliproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter @Getter
@NoArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column (length = 100, nullable = false, unique = true)
    String categoryName;

    @Column (nullable = false)
    int minTemperature;

    @Column (nullable = false)
    int maxTemperature;
}
