/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.pgn0079.toreba.model.dao.impl;

import br.estacio.pgn0079.toreba.model.dao.CampeonatoDAO;
import br.estacio.pgn0079.toreba.model.entity.Campeonato;
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
public class CampeonatoDAOImpl extends GenericDAOImpl<Campeonato>
  implements CampeonatoDAO {

  public CampeonatoDAOImpl() {
    super(Campeonato.class, "Campeonato.listAll", "nome");
  }

  @Override
  public List<Campeonato> autoComplete(String query) {
    return super.autoComplete(query); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public int getQtdeRecords() {
    return super.getQtdeRecords(); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Campeonato> listAll(int first, int pageSize) throws Exception {
    return super.listAll(first, pageSize); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Campeonato> queryByExample(Campeonato obj) throws Exception {
    return super.queryByExample(obj); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Campeonato> listAll() throws Exception {
    return super.listAll(); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Campeonato find(Long id) throws Exception {
    return super.find(id); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  @RolesAllowed({"admin"})
  public boolean remove(Campeonato obj) throws Exception {
    return super.remove(obj); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Campeonato update(Campeonato obj) throws Exception {
    return super.update(obj); 
  }

  @Override
  @RolesAllowed({"admin", "users"})
  public void insert(Campeonato obj) throws Exception {
    super.insert(obj); //To change body of generated methods, choose Tools | Templates.
  }

  
}
