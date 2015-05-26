/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.pgn0079.toreba.model.dao.impl;

import br.estacio.pgn0079.toreba.model.dao.EstadioDAO;
import br.estacio.pgn0079.toreba.model.entity.Estadio;
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
public class EstadioDAOImpl extends GenericDAOImpl<Estadio>
  implements EstadioDAO {

  public EstadioDAOImpl() {
    super(Estadio.class, "Estadio.listAll", "nome");
  }

  @Override
  public List<Estadio> autoComplete(String query) {
    return super.autoComplete(query); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public int getQtdeRecords() {
    return super.getQtdeRecords(); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Estadio> listAll(int first, int pageSize) throws Exception {
    return super.listAll(first, pageSize); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Estadio> queryByExample(Estadio obj) throws Exception {
    return super.queryByExample(obj); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Estadio> listAll() throws Exception {
    return super.listAll(); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Estadio find(Long id) throws Exception {
    return super.find(id); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  @RolesAllowed({"admin"})
  public boolean remove(Estadio obj) throws Exception {
    return super.remove(obj); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Estadio update(Estadio obj) throws Exception {
    return super.update(obj); 
  }

  @Override
  @RolesAllowed({"admin", "users"})
  public void insert(Estadio obj) throws Exception {
    super.insert(obj); //To change body of generated methods, choose Tools | Templates.
  }

  
}
