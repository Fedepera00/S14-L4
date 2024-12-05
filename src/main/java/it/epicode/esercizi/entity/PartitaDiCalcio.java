package it.epicode.esercizi.entity;

import jakarta.persistence.Entity;

@Entity
public class PartitaDiCalcio extends Evento {

    private String squadraCasa;
    private String squadraOspite;
    private String squadraVincente; // Null se pareggio
    private int golSquadraCasa;
    private int golSquadraOspite;

    // Getters e Setters
    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getGolSquadraCasa() {
        return golSquadraCasa;
    }

    public void setGolSquadraCasa(int golSquadraCasa) {
        this.golSquadraCasa = golSquadraCasa;
    }

    public int getGolSquadraOspite() {
        return golSquadraOspite;
    }

    public void setGolSquadraOspite(int golSquadraOspite) {
        this.golSquadraOspite = golSquadraOspite;
    }
}