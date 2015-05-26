/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.pgn0079.toreba.model.dao.impl;

import br.estacio.pgn0079.toreba.model.dao.TimeDAO;
import br.estacio.pgn0079.toreba.model.entity.Time;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 *
 * @author michel
 */
@Stateless
@DeclareRoles({"admin", "users", "guest"})
public class TimeDAOImpl extends GenericDAOImpl<Time>
  implements TimeDAO {

  public TimeDAOImpl() {
    super(Time.class, "Time.listAll", "nome");
  }

  @Override
  public List<Time> autoComplete(String query) {
    return super.autoComplete(query); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public int getQtdeRecords() {
    return super.getQtdeRecords(); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Time> listAll(int first, int pageSize) throws Exception {
    return super.listAll(first, pageSize); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Time> queryByExample(Time obj) throws Exception {
    return super.queryByExample(obj); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Time> listAll() throws Exception {
    return super.listAll(); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Time find(Long id) throws Exception {
    return super.find(id); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  @RolesAllowed({"admin"})
  public boolean remove(Time obj) throws Exception {
    return super.remove(obj); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Time update(Time obj) throws Exception {
    return super.update(obj); 
  }

  @Override
  @RolesAllowed({"admin", "users"})
  public void insert(Time obj) throws Exception {
    super.insert(obj); //To change body of generated methods, choose Tools | Templates.
  }

  
}
