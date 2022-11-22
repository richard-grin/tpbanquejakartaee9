package fr.grin.tpbanque.ejb;

import fr.grin.tpbanque.entities.CompteBancaire;
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 * Gère la persistance pour l'entité CompteBancaire.
 *
 * @author grin
 */
@DataSourceDefinition(
        className = "com.mysql.cj.jdbc.MysqlDataSource",
        name = "java:app/jdbc/banque",
        serverName = "localhost",
        portNumber = 3306,
        user = "toto", // nom et
        password = "ric088", // mot de passe que vous avez donnés lors de la création de la base de données
        databaseName = "banque2",
        properties = {
            "useSSL=false",
            "allowPublicKeyRetrieval=true"
        }
)
@Stateless
public class GestionnaireCompte {

    @PersistenceContext
    private EntityManager em;

    public void creerCompte(CompteBancaire c) {
        em.persist(c);
    }

    public List<CompteBancaire> getAllComptes() {
        TypedQuery query
                = em.createQuery("select c from CompteBancaire c", CompteBancaire.class);
        return query.getResultList();
    }

    /**
     * Retourne le nombre de comptes bancaires dans la base de données.
     *
     * @return
     */
    public long nbComptes() {
        String q = "select count(c) from CompteBancaire c";
        TypedQuery<Long> query = em.createQuery(q, Long.class);
        return query.getSingleResult();
    }

    public void transferer(CompteBancaire source, CompteBancaire destination,
            int montant) {
        source.retirer(montant);
        destination.deposer(montant);
        update(source);
        update(destination);
    }

    public CompteBancaire update(CompteBancaire compteBancaire) {
        return em.merge(compteBancaire);
    }

    /**
     * Retourne le compte bancaire qui a le id passé en paramètre.
     * @param id
     * @return 
     */
    public CompteBancaire getCompte(Long id) {
        return em.find(CompteBancaire.class, id);
    }

}
