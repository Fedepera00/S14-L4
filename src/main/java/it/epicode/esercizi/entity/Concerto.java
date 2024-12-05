package it.epicode.esercizi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Concerto extends Evento {

    @Enumerated(EnumType.STRING)
    private GenereConcerto genere;
    private boolean inStreaming;

    // Getters e Setters
    public GenereConcerto getGenere() {
        return genere;
    }

    public void setGenere(GenereConcerto genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }
}