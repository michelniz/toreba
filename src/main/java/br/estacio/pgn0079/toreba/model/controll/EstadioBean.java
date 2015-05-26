/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.pgn0079.toreba.model.controll;

import br.estacio.pgn0079.toreba.model.dao.EstadioDAO;
import br.estacio.pgn0079.toreba.model.entity.Estadio;
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
public class EstadioBean {

  @EJB
  private EstadioDAO dao;

  private Estadio estadio;
  private LazyDataModel<Estadio> estadios;
  private List<Estadio> list;

  @PostConstruct
  public void init() {
    estadio = new Estadio();
  }

  public Estadio getEstadio() {
    return estadio;
  }

  public void setEstadio(Estadio estadio) {
    this.estadio = estadio;
  }

  public LazyDataModel<Estadio> getEstadios() {
    try {
      if (estadios == null) {
        estadios = new Paginacao<Estadio, EstadioDAO>(dao);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return estadios;
  }

  public void setEstadios(LazyDataModel<Estadio> deptos) {
    this.estadios = deptos;
  }

  public String actionSalvar() {
    try {
      if (estadio.getId() == null) {
        dao.insert(estadio);
      } else {
        estadio = dao.update(estadio);
      }
      init();
      estadios = null;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public String actionExcluir() {
    try {
      dao.remove(estadio);
      init();
      estadios = null;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public List<Estadio> getList() {
    if (list == null) {
      try {
        list = dao.listAll();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return list;
  }

  public void setList(List<Estadio> list) {
    this.list = list;
  }

  public List<Estadio> autoComplete(String query) {
    return dao.autoComplete(query);
  }
}
