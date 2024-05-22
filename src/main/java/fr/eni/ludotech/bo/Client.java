package fr.eni.ludotech.bo;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("C")
@Table(name="CLIENT")
public class Client extends Utilisateur {
    @Column(length = 10)
    private String telephone;

    @OneToOne(cascade = CascadeType.ALL)
    private Adresse adresse;

}
