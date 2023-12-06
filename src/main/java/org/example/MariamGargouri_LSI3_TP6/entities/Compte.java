package org.example.MariamGargouri_LSI3_TP6.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;
@Getter // générer automatiquement les méthodes getter
@Setter // générer automatiquement des méthodes seter
@ToString // générer automatiquement la méthode ToString()
@Entity //cette annotation permet de tranformer la classe Compte une entité dans la BD
@NoArgsConstructor // générer des constructeurs sans argument
@AllArgsConstructor // générer des constructeurs avec tous les arguments
    public class Compte {
        @Id //primary key
        @GeneratedValue(strategy = GenerationType.IDENTITY) /* cette strategie permet d'incrementer le id automatiquement
    a chaque fois un compte sera ajouter*/
        private Long id;
        private double solde;
        private Date datecreation;
        private TypeCompte type; //Type de compte, qui peut être soit COURANT soit EPARGNE.
        private EtatCompte etat;//Etat de compte, qui peut être CREE, ACTIVE, SUSPENDU, BLOQUE
    }

