package fr.eni.ludotech.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.ludotech.bo.Location;

public interface LocationRepository extends JpaRepository<Location, Integer>{

}
