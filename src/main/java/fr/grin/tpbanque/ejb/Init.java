package fr.grin.tpbanque.ejb;

import fr.grin.tpbanque.entities.CompteBancaire;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;

/**
 * EJB exécuté au lancement de l'application pour initialiser la base de données.
 * @author grin
 */
@Singleton
@Startup
public class Init {
    @EJB
    private GestionnaireCompte gestionnaireCompte;
    
    @PostConstruct
    public void creerComptes() {
        if (gestionnaireCompte.nbComptes() == 0) {
            // Création des 4 comptes
            gestionnaireCompte.creerCompte(new CompteBancaire("John Lennon", 150000));
            gestionnaireCompte.creerCompte(new CompteBancaire("Paul McCartney", 950000));
            gestionnaireCompte.creerCompte(new CompteBancaire("Georges Harrisson", 100000));
            gestionnaireCompte.creerCompte(new CompteBancaire("Ringo Starr", 20000));
        }
    }
    
    
}
