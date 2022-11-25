package fr.grin.tpbanque.jsf;


import fr.grin.tpbanque.ejb.GestionnaireCompte;
import fr.grin.tpbanque.entities.CompteBancaire;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 * Backing bean pour la page changerNom.xhtml.
 * @author grin
 */
@Named(value = "changerNom")
@ViewScoped
public class ChangerNom implements Serializable {
    private Long id;
    private CompteBancaire compte;
    
    @EJB
    private GestionnaireCompte gestionnaireCompte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompteBancaire getCompte() {
        return compte;
    }
    
    public String changerNom() {
        gestionnaireCompte.update(compte);
        return "listeComptes?faces-redirect=true";
    }

    public void loadCompte() {
        compte = gestionnaireCompte.getCompte(id);
    }
    
}
