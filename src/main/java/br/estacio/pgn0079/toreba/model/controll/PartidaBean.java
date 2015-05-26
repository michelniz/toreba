/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.pgn0079.toreba.model.controll;

import br.estacio.pgn0079.toreba.model.dao.PartidaDAO;
import br.estacio.pgn0079.toreba.model.entity.Partida;
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
public class PartidaBean {

  @EJB
  private PartidaDAO dao;

  private Partida partida;
  private LazyDataModel<Partida> partidas;
  private List<Partida> list;

  @PostConstruct
  public void init() {
    partida = new Partida();
  }

  public Partida getPartida() {
    return partida;
  }

  public void setPartida(Partida partida) {
    this.partida = partida;
  }

  public LazyDataModel<Partida> getPartidas() {
    try {
      if (partidas == null) {
        partidas = new Paginacao<Partida, PartidaDAO>(dao);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return partidas;
  }

  public void setPartidas(LazyDataModel<Partida> deptos) {
    this.partidas = deptos;
  }

  public String actionSalvar() {
    try {
      if (partida.getId() == null) {
        dao.insert(partida);
      } else {
        partida = dao.update(partida);
      }
      
      init();
      partidas = null;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public String actionExcluir() {
    try {
      dao.remove(partida);
      
      init();
      partidas = null;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public List<Partida> getList() {
    if (list == null) {
      try {
        list = dao.listAll();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return list;
  }

  public void setList(List<Partida> list) {
    this.list = list;
  }

  public List<Partida> autoComplete(String query) {
    return dao.autoComplete(query);
  }
}
