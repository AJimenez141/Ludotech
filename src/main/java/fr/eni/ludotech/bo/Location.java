package fr.eni.ludotech.bo;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@ToString
@Builder
@Entity
@Table(name="LOCATION")
public class Location {

    @Id
    @GeneratedValue()
    private Integer id;

    @Column(name = "date_loc")
    private Date dateLocation;

    @Column(name = "est_paye")
    private boolean estPaye;

    @OneToMany(mappedBy = "location", cascade = CascadeType.PERSIST)
    private List<LocationExemplaire> locationExemplaires;

    @ManyToOne()
    private Client client;
}
