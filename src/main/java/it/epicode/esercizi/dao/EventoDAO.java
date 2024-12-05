package it.epicode.esercizi.dao;

import it.epicode.esercizi.entity.Concerto;
import it.epicode.esercizi.entity.GenereConcerto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

public class EventoDAO {

    @PersistenceContext
    private EntityManager em;

    // Setter per EntityManager
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    /**
     * Ottiene tutti i concerti che sono o non sono in streaming.
     *
     * @param inStreaming true se i concerti sono in streaming, false altrimenti
     * @return Lista di concerti in base al filtro
     */
    public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
        return em.createQuery(
                        "SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming", Concerto.class)
                .setParameter("inStreaming", inStreaming)
                .getResultList();
    }

    /**
     * Ottiene tutti i concerti filtrati per genere.
     *
     * @param genere Il genere del concerto (es. CLASSICO, ROCK, POP)
     * @return Lista di concerti per genere
     */
    public List<Concerto> getConcertiPerGenere(GenereConcerto genere) {
        return em.createQuery(
                        "SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class)
                .setParameter("genere", genere)
                .getResultList();
    }
}