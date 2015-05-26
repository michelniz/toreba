/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.pgn0079.toreba.model.controll;

import br.estacio.pgn0079.toreba.model.dao.CampeonatoDAO;
import br.estacio.pgn0079.toreba.model.entity.Campeonato;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.LazyDataModel;

/**
 *
 * @author michel
 */
@ManagedBean
@ViewScoped
public class CampeonatoBean {

  @EJB
  private CampeonatoDAO dao;

  private Campeonato campeonato;
  private LazyDataModel<Campeonato> campeonatos;
  private List<Campeonato> list;

  @PostConstruct
  public void init() {
    this.campeonato = new Campeonato();
  }

  public Campeonato getCampeonato() {
    return campeonato;
  }

  public void setCampeonato(Campeonato campeonato) {
    this.campeonato = campeonato;
  }

  public LazyDataModel<Campeonato> getCampeonatos() {
    try {
      if (campeonatos == null) {
        campeonatos = new Paginacao<Campeonato, CampeonatoDAO>(dao);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return campeonatos;
  }

  public void setCampeonatos(LazyDataModel<Campeonato> deptos) {
    this.campeonatos = deptos;
  }

  public String actionSalvar() {
    try {
      if (campeonato.getId() == null) {
        dao.insert(campeonato);
      } else {
        campeonato = dao.update(campeonato);
      }
      
      init();
      campeonatos = null;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public String actionExcluir() {
    try {
      dao.remove(campeonato);
      
      init();
      campeonatos = null;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public List<Campeonato> getList() {
    if (list == null) {
      try {
        list = dao.listAll();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return list;
  }

  public void setList(List<Campeonato> list) {
    this.list = list;
  }

  public List<Campeonato> autoComplete(String query) {
    return dao.autoComplete(query);
  }
}
