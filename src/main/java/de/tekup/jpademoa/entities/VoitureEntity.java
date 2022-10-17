package de.tekup.jpademoa.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@JsonIdentityInfo(property = "id",generator = ObjectIdGenerators.PropertyGenerator.class)
public class VoitureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String serie;

    private LocalDate dateDeMiseEnMarche;
    private String model;

    @OneToMany(mappedBy = "voiture")
    List<LocationEntity> locations;

}
