package fr.eni.ludotech.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.ludotech.bo.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	Client findByTelephone(String telephone);
}
