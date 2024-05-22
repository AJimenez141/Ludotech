package fr.eni.ludotech.bo;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@ToString
@Builder
@Entity
@Table(name="GENRE")
public class Genre {
    @Id
    @GeneratedValue()
    private Integer id;

    @Column(name = "libelle")
    private String libelle;
}
