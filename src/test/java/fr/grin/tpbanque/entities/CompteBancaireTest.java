package fr.grin.tpbanque.entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author grin
 */
public class CompteBancaireTest {

    public CompteBancaireTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of deposer method, of class CompteBancaire.
     */
    @org.junit.jupiter.api.Test
    public void testDeposer() {
        System.out.println("deposer");
        int montant = 100;
        CompteBancaire instance = new CompteBancaire();
        instance.deposer(montant);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getSolde(), montant, "Mauvais calcul du solde après un dépôt");
    }

    @Test
    public void testConstructor() {
        int montant = 100;
        CompteBancaire instance = new CompteBancaire("toto", montant);
        assertEquals(instance.getNom(), "toto", "Nom titulaire compte mal enregistré dans l'instance");
        assertEquals(instance.getSolde(), montant, "Montant compte mal enregistré dans l'instance");
    }
}
