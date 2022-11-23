package fr.grin.tpbanque.jsf;

import fr.grin.tpbanque.ejb.GestionnaireCompte;
import fr.grin.tpbanque.entities.CompteBancaire;
import fr.grin.tpbanque.jsf.util.Util;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

/**
 * Backing bean pour la page ajout.xhtml pour ajouter un nouveau compte bancaire.
 * @author grin
 */
@Named(value = "ajoutCompte")
@RequestScoped
public class AjoutCompte {
    private String nom;
    private int solde;
    
    @EJB
    private GestionnaireCompte gestionnaireCompte;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public String ajouterCompte() {
        gestionnaireCompte.creerCompte(new CompteBancaire(nom, solde));
        Util.addFlashInfoMessage("Compte de " + nom + " ajouté");
        return "ajoutCompte?faces-redirect=true";
    }
}
