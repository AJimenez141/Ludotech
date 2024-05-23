package fr.eni.ludotech.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.ludotech.bo.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer>{

}
