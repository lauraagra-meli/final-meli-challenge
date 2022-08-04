package meli.dh.com.finalmeliproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {
    @Id
    long id;

    @Column
    String categoryName;


    int minTemperature;


    int maxTemperature;
}
