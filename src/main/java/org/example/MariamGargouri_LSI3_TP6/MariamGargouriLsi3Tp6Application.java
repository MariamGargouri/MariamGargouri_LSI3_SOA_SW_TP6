package org.example.MariamGargouri_LSI3_TP6;

import org.example.MariamGargouri_LSI3_TP6.entities.Compte;
import org.example.MariamGargouri_LSI3_TP6.entities.EtatCompte;
import org.example.MariamGargouri_LSI3_TP6.entities.TypeCompte;
import org.example.MariamGargouri_LSI3_TP6.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication // pour marquer la classe principale d'une application Spring Boot.
public class MariamGargouriLsi3Tp6Application {

	public static void main(String[] args) {
		SpringApplication.run(MariamGargouriLsi3Tp6Application.class, args);
	}
	@Bean//est utilisée au niveau des méthodes pour définir des composants spécifiques à enregistrer dans le contexte de l'application Spring.
	public CommandLineRunner start(CompteRepository compterep) {
		return args -> {
			Compte compte1 = new Compte(null, 123, new Date(),TypeCompte.EPARGNE, EtatCompte.ACTIVE);
			Compte compte2 = new Compte(null, 145,new Date(),TypeCompte.EPARGNE,EtatCompte.ACTIVE);
			Compte compte3= new Compte(null,255,new Date(), TypeCompte.COURANT, EtatCompte.SUSPENDU);

			compterep.save(compte1); // permet de sauvegarder le compte1  en tant que ligne dans l'entite
			compterep.save(compte2);
			compterep.save(compte3);
			compterep.findAll().forEach(c->{ // gerer les comptes comme etant une liste
				System.out.println(c.getSolde()); // afficher les soldes des comptes
			});

		};


	}
}
