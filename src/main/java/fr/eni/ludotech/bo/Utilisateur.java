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
@DiscriminatorColumn(name="utilisateur_type")
public abstract class Utilisateur {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="last_name", length = 50, nullable=false)
    private String nom;

    @Column(name="first_name", length = 50, nullable = false)
    private String prenom;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;
}
