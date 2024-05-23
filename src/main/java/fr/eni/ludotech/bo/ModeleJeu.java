package fr.eni.ludotech.bo;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@ToString
@Builder
@Entity
@Table(name="MODELE_JEU")
public class ModeleJeu {
    @Id
    @GeneratedValue()
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prix")
    private double prixLocation;

    @ManyToMany(fetch = FetchType.EAGER)
    @Builder.Default
    private List<Genre> genres = new ArrayList<>();
}
