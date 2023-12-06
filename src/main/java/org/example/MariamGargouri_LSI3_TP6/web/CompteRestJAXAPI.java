package org.example.MariamGargouri_LSI3_TP6.web;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.MariamGargouri_LSI3_TP6.entities.Compte;
import org.example.MariamGargouri_LSI3_TP6.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // indique qu'une classe est un composant géré par spring
@Path("/banque")
public class CompteRestJAXAPI {

    @Autowired// utilisée pour injecter automatiquement une dépendance
    private CompteRepository compteRepository;// pour effectuer les opérations de gestion des comptes


    @Path("/comptes")//Lorsque l'application Jax-RS reçoit une requette HTTP avec un chemin correspondant à "/comptes",
                        //elle dirigera la requete vers la méthode compteList()
    @GET
    @Produces
            ({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})//pour indiquer que la méthode "compteList" produit des réponses au format json et xml
    @Transactional // indique à spring que la méthode annotée doit etre exécutée dans un contexte transactionnel
    public List<Compte> compteList()
        {
            return compteRepository.findAll();//Pour la récupération de la liste des comptes bancaires au format JSON
        }


    @Path("/comptes/{id}")//orsque l'application Jax-RS reçoit une requette HTTP avec un chemin correspondant à "/comptes/{id}",
                            //elle dirigera la requete vers la méthode getone()
    @GET
    @Produces({MediaType.APPLICATION_JSON}) //pour indiquer que la méthode "compteList" produit des réponses au format json
    public Compte getone(@PathParam(value="id") Long id)
        {
            return compteRepository.findById(id).get();//Pour la récupération d'un compte à partir de son id
        }
    //@PathParam(value="id") permet de récupérer la valeur dynamique id à partir de l'URL et de la passer en tant que parametre à la méthode


    @Path("/comptes")
    @POST
    @Produces({MediaType.APPLICATION_JSON})//pour indiquer que la méthode "save" produit des réponses au format JSON
    @Consumes({MediaType.APPLICATION_JSON})//pour indiquer que la méthode "save" consomme des données JSON en tant que charge utile de la requete
    public Compte save(Compte compte)
        {
            return compteRepository.save(compte);//pour la création d'un nouveau compte
        }


    @Path("/comptes/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})//pour indiquer que la méthode "update" produit des réponses au format JSON
    public Compte update(Compte compte ,@PathParam("id")Long id)
        {
            compte.setId(id);
            return compteRepository.save(compte);// pour mettreà jour un compte existant
        }


    @Path("/comptes/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})//pour indiquer que la méthode "update" produit des réponses au format JSON
    public void delete (@PathParam("id")Long id)
        {
            compteRepository.deleteById(id);// pour supprimer un compte
        }
}
