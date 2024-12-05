package it.epicode.esercizi.main;

import it.epicode.esercizi.dao.EventoDAO;
import it.epicode.esercizi.entity.Concerto;
import it.epicode.esercizi.entity.GenereConcerto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Configura EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Relationships_Project");
        EntityManager em = emf.createEntityManager();

        // Configura EventoDAO con EntityManager
        EventoDAO eventoDAO = new EventoDAO();
        eventoDAO.setEntityManager(em);

        try {
            // Query: Concerti in streaming
            System.out.println("Concerti in streaming:");
            List<Concerto> concertiInStreaming = eventoDAO.getConcertiInStreaming(true);
            concertiInStreaming.forEach(c -> System.out.println(" - " + c.getTitolo()));

            // Query: Concerti per genere ROCK
            System.out.println("\nConcerti ROCK:");
            List<Concerto> concertiRock = eventoDAO.getConcertiPerGenere(GenereConcerto.ROCK);
            concertiRock.forEach(c -> System.out.println(" - " + c.getTitolo()));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}