package fr.grin.tpbanque.jsf;


import fr.grin.tpbanque.ejb.GestionnaireCompte;
import fr.grin.tpbanque.entities.CompteBancaire;
import fr.grin.tpbanque.jsf.util.Util;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;

/**
 * Backing bean pour la page qui liste tous les comptes bancaires.
 *
 * @author grin
 */
@Named(value = "listeComptes")
@ViewScoped
public class ListeComptes implements Serializable {

    @EJB
    private GestionnaireCompte gestionnaireCompte;

    private List<CompteBancaire> listeComptes;

    /**
     * Creates a new instance of ListeComptes
     */
    public ListeComptes() {
    }

    public List<CompteBancaire> getAllComptes() {
        if (listeComptes == null) {
            listeComptes = gestionnaireCompte.getAllComptes();
        }
        return listeComptes;
    }

    public boolean filtrerSolde(Object valeurTable, Object valeurFiltre, Locale locale) {
        try {
        return (Integer)valeurTable >= Integer.valueOf((String)valeurFiltre);
        } catch (NumberFormatException e) {
            // L’utilisateur a tapé autre chose qu’un nombre entier dans la zone pour filtrer
            return false;
        }
    }

}
