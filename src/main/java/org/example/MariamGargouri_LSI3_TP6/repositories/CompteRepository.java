package org.example.MariamGargouri_LSI3_TP6.repositories;

import org.example.MariamGargouri_LSI3_TP6.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long> {
    //Compte c'est la classe et Long c'est le type primitive  de l'ID

}
