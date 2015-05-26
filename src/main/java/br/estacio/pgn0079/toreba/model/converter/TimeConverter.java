/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.pgn0079.toreba.model.converter;

import br.estacio.pgn0079.toreba.model.dao.TimeDAO;
import br.estacio.pgn0079.toreba.model.entity.Time;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

/**
 *
 * @author michel
 */
@Named
public class TimeConverter implements Converter {

  @EJB
  TimeDAO dao;

  @Override
  public Object getAsObject(FacesContext context, UIComponent component, String value) {
    try {
      return dao.find(Long.parseLong(value));
    } catch (Exception e) {
      return null;
    }
  }

  @Override
  public String getAsString(FacesContext context, UIComponent component, Object value) {
    String id = "";
    if (value instanceof Time) {
      id = ((Time) value).getId().toString();
    }
    return id;
  }

}
