package fr.eni.ludotech.bo;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.context.annotation.Configuration;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("E")
@Table(name="EMPLOYEE")
public class Employe extends Utilisateur {}
