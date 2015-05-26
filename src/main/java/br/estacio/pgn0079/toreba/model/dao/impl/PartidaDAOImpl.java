/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.pgn0079.toreba.model.dao.impl;

import br.estacio.pgn0079.toreba.model.dao.PartidaDAO;
import br.estacio.pgn0079.toreba.model.entity.Partida;
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
public class PartidaDAOImpl extends GenericDAOImpl<Partida>
  implements PartidaDAO {

  public PartidaDAOImpl() {
    super(Partida.class, "Partida.listAll", "dataJogo");
  }
  
  @Override
  public List<Partida> autoComplete(String query) {
    return super.autoComplete(query); //To change body of generated methods, choose Tools | Templates.
  }
 
  @Override
  public int getQtdeRecords() {
    return super.getQtdeRecords(); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Partida> listAll(int first, int pageSize) throws Exception {
    return super.listAll(first, pageSize); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Partida> queryByExample(Partida obj) throws Exception {
    return super.queryByExample(obj); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Partida> listAll() throws Exception {
    return super.listAll(); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Partida find(Long id) throws Exception {
    return super.find(id); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  @RolesAllowed({"admin"})
  public boolean remove(Partida obj) throws Exception {
    return super.remove(obj); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Partida update(Partida obj) throws Exception {
    return super.update(obj); 
  }

  @Override
  @RolesAllowed({"admin", "users"})
  public void insert(Partida obj) throws Exception {
    super.insert(obj); //To change body of generated methods, choose Tools | Templates.
  }

  
}
