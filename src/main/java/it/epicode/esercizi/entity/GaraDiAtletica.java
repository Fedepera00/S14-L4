package it.epicode.esercizi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.Set;

@Entity
public class GaraDiAtletica extends Evento {

    @OneToMany
    private Set<Persona> atleti;

    @OneToOne
    private Persona vincitore;

    // Getters e Setters
    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }
}