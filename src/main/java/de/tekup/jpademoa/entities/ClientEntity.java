package de.tekup.jpademoa.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "client")
@Data
@NoArgsConstructor
public class ClientEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private Integer cin;
    @Column(length = 50,nullable = false)
    private String nom;
    @Column(length = 50)
    private String prenom;
    private String adresse;

    @ManyToOne
    private Company company;

    public ClientEntity(Integer cin, String nom, String prenom, String adresse) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

}
