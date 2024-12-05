package it.epicode.esercizi.dao;

import it.epicode.esercizi.entity.Partecipazione;
import it.epicode.esercizi.entity.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

public class PartecipazioneDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * Ottiene tutte le partecipazioni da confermare per un evento specifico.
     *
     * @param evento L'evento per cui ottenere le partecipazioni
     * @return Lista di partecipazioni con stato "DA_CONFERMARE"
     */
    public List<Partecipazione> getPartecipazioniDaConfermarePerEvento(Evento evento) {
        if (evento == null || evento.getId() == null) {
            throw new IllegalArgumentException("L'evento fornito è nullo o privo di ID.");
        }
        return em.createQuery(
                        "SELECT p FROM Partecipazione p WHERE p.evento = :evento AND p.stato = 'DA_CONFERMARE'",
                        Partecipazione.class)
                .setParameter("evento", evento)
                .getResultList();
    }
}