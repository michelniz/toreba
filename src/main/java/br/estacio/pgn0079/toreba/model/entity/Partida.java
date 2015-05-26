/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.pgn0079.toreba.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author michel
 */
@Entity
@NamedQuery(name ="Partida.listAll", query="from Partida c order by c.dataJogo")
public class Partida implements GenericEntity, Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dataJogo;
    
    @OneToOne
    @JoinColumn(name="idestadio")
    private Estadio estadio;
    
    @OneToOne
    @JoinColumn(name="idmanda")
    private Time manda;
    
    @OneToOne
    @JoinColumn(name="idvisita")
    private Time visita;
    
    private int placarManda;
    
    private int placarVisita;
    
    @ManyToOne
    @JoinColumn(name = "idcampeonato")
    private Campeonato campeonato;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataJogo() {
        return dataJogo;
    }

    public void setDataJogo(Date dataJogo) {
        this.dataJogo = dataJogo;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public Time getManda() {
        return manda;
    }

    public void setManda(Time manda) {
        this.manda = manda;
    }

    public Time getVisita() {
        return visita;
    }

    public void setVisita(Time visita) {
        this.visita = visita;
    }

    public int getPlacarManda() {
        return placarManda;
    }

    public void setPlacarManda(int placarManda) {
        this.placarManda = placarManda;
    }

    public int getPlacarVisita() {
        return placarVisita;
    }

    public void setPlacarVisita(int placarVisita) {
        this.placarVisita = placarVisita;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }
    
    
}