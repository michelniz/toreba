/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.pgn0079.toreba.model.controll;

import br.estacio.pgn0079.toreba.model.dao.TimeDAO;
import br.estacio.pgn0079.toreba.model.entity.Time;
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
public class TimeBean {

  @EJB
  private TimeDAO dao;

  private Time time;
  private LazyDataModel<Time> times;
  private List<Time> list;

  @PostConstruct
  public void init() {
    this.time = new Time();
  }

  public Time getTime() {
    return time;
  }

  public void setTime(Time time) {
    this.time = time;
  }

  public LazyDataModel<Time> getTimes() {
    try {
      if (times == null) {
        times = new Paginacao<Time, TimeDAO>(dao);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return times;
  }

  public void setTimes(LazyDataModel<Time> deptos) {
    this.times = deptos;
  }

  public String actionSalvar() {
    try {
      if (time.getId() == null) {
        dao.insert(time);
      } else {
        time = dao.update(time);
      }
      
      init();
      times = null;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public String actionExcluir() {
    try {
      dao.remove(time);
      
      init();
      times = null;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public List<Time> getList() {
    if (list == null) {
      try {
        list = dao.listAll();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return list;
  }

  public void setList(List<Time> list) {
    this.list = list;
  }

  public List<Time> autoComplete(String query) {
    return dao.autoComplete(query);
  }
}
