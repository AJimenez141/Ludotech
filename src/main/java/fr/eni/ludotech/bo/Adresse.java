package fr.eni.ludotech.bo;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Builder
@Entity
@Table(name="ADDRESS")
public class Adresse {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10)
    private String numero;

    @Column(length = 50, nullable = false)
    private String rue;

    @Column(length = 50, nullable = false)
    private String codePostal;

    @Column(length = 50, nullable = false)
    private String ville;
}
