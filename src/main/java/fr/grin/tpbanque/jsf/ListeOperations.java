package fr.grin.tpbanque.jsf;


import fr.grin.tpbanque.ejb.GestionnaireCompte;
import fr.grin.tpbanque.entities.CompteBancaire;
import fr.grin.tpbanque.entities.OperationBancaire;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Backing bean de la page JSF listeOperations.
 * @author grin
 */
@Named(value = "listeOperations")
@ViewScoped
public class ListeOperations implements Serializable {
    private Long idCompte;
    private CompteBancaire compte;
    
    @EJB
    private GestionnaireCompte gestionnaireCompte;
    
    public void loadCompte() {
        this.compte = gestionnaireCompte.getCompte(idCompte);
        System.out.println("idCompte=" + this.idCompte + "; compte de " + this.compte.getNom());
    }
    
    public List<OperationBancaire> getAllOperations() {
        return compte.getOperations();
    }

    public Long getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Long idCompte) {
        this.idCompte = idCompte;
    }
}
