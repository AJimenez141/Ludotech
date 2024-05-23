package fr.eni.ludotech.bo;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@ToString
@Entity
@EqualsAndHashCode(of = "id")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
public abstract class Utilisateur {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="nom", length = 50, nullable=false)
    private String nom;

    @Column(name="prenom", length = 50, nullable = false)
    private String prenom;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "mot_de_passe", nullable = false)
    private String password;
}
