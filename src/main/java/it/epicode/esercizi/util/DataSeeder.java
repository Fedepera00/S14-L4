package it.epicode.esercizi.util;

import com.github.javafaker.Faker;
import it.epicode.esercizi.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Random;

public class DataSeeder {

    private static final Faker faker = new Faker();
    private static final Random random = new Random();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Relationships_Project");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Generazione di Persone
        for (int i = 0; i < 20; i++) {
            Persona persona = new Persona();
            persona.setNome(faker.name().fullName());
            em.persist(persona); // ID generato automaticamente
        }

        // Generazione di Concerti
        for (int i = 0; i < 5; i++) {
            Concerto concerto = new Concerto();
            concerto.setTitolo(faker.music().genre() + " Live");
            concerto.setDescrizione("Concerto di " + faker.music().instrument());
            concerto.setDataEvento(LocalDate.now().plusDays(random.nextInt(30)));
            concerto.setNumeroMassimoPartecipanti(random.nextInt(500) + 100);
            concerto.setGenere(GenereConcerto.values()[random.nextInt(GenereConcerto.values().length)]);
            concerto.setInStreaming(random.nextBoolean());
            em.persist(concerto);
        }

        // Generazione di Partecipazioni
        for (int i = 0; i < 20; i++) {
            Partecipazione partecipazione = new Partecipazione();
            Evento evento = em.find(Evento.class, (long) random.nextInt(5) + 1); // Recupera evento gestito
            Persona persona = em.find(Persona.class, (long) random.nextInt(20) + 1); // Recupera persona gestita
            partecipazione.setEvento(evento);
            partecipazione.setPersona(persona);
            partecipazione.setStato(random.nextBoolean() ? Stato.CONFERMATA : Stato.DA_CONFERMARE);
            em.persist(partecipazione);
        }

        em.getTransaction().commit();
        em.close();
        emf.close();

        System.out.println("Dati generati con successo!");
    }
}