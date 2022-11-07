package de.tekup.jpademoa.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "client")
@Data
@NoArgsConstructor
@JsonIdentityInfo(property = "cin",generator = ObjectIdGenerators.PropertyGenerator.class)
public class ClientEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    @Pattern(regexp = "^[0-9]{8}$", message = "Cin not valid")
    private String cin;
    @Column(length = 50,nullable = false)
    @NotBlank
    @Size(max = 50, min = 3)
    private String nom;
    @Column(length = 50)
    @NotBlank
    @Size(max = 50, min = 3)
    private String prenom;
    private String adresse;

    @OneToMany(mappedBy = "client")
    private List<LocationEntity> locations;


    public ClientEntity(String cin, String nom, String prenom, String adresse) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

}
