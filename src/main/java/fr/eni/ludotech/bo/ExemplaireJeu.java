package fr.eni.ludotech.bo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@ToString
@Builder
@Entity
@Table(name="EXEMPLAIRE_JEU")
public class ExemplaireJeu {
    @Id
    @GeneratedValue()
    private Integer id;

    @Column(name = "code_barre")
    private String codeBarre;

    @Column(name = "est_louable")
    private boolean estLouable;

    @ManyToOne()
    private ModeleJeu modeleJeu;

//    @ManyToOne()
//    private Reservation reservation;

    @Column(name = "date_reservation")
    private LocalDate dateReservation;

    @ManyToOne()
    @JoinColumn(name = "reservation_client_id")
    private Client reservationClient;
}
