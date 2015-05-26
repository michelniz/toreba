/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.pgn0079.toreba.model.dao.impl;

import br.estacio.pgn0079.toreba.model.dao.ClassificacaoDAO;
import br.estacio.pgn0079.toreba.model.entity.Classificacao;
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
public class ClassificacaoDAOImpl extends GenericDAOImpl<Classificacao>
  implements ClassificacaoDAO {

  public ClassificacaoDAOImpl() {
    super(Classificacao.class, "Classificacao.listAll", "time");
  }

  @Override
  public List<Classificacao> autoComplete(String query) {
    return super.autoComplete(query); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public int getQtdeRecords() {
    return super.getQtdeRecords(); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Classificacao> listAll(int first, int pageSize) throws Exception {
    return super.listAll(first, pageSize); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Classificacao> queryByExample(Classificacao obj) throws Exception {
    return super.queryByExample(obj); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Classificacao> listAll() throws Exception {
    return super.listAll(); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Classificacao find(Long id) throws Exception {
    return super.find(id); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  @RolesAllowed({"admin"})
  public boolean remove(Classificacao obj) throws Exception {
    return super.remove(obj); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Classificacao update(Classificacao obj) throws Exception {
    return super.update(obj); 
  }

  @Override
  @RolesAllowed({"admin", "users"})
  public void insert(Classificacao obj) throws Exception {
    super.insert(obj); //To change body of generated methods, choose Tools | Templates.
  }

  
}
