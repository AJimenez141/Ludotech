package fr.eni.ludotech.bo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "LOCATION_EXEMPLAIRE")

public class LocationExemplaire {

    @Id
    @GeneratedValue()
    private Integer id;

    @ManyToOne()
//    @JoinColumn(name = "id_location")
    private Location location;

    @ManyToOne()
    @JoinColumn(name = "id_exemplaire")
    private ExemplaireJeu exemplaireJeu;

    @Column(name = "date_fin")
    private LocalDate dateFin;

    @Column(name = "prix_final")
    private Double prixFinal;

}
