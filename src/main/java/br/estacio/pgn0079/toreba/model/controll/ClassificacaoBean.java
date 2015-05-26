/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.pgn0079.toreba.model.controll;

import br.estacio.pgn0079.toreba.model.dao.ClassificacaoDAO;
import br.estacio.pgn0079.toreba.model.entity.Classificacao;
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
public class ClassificacaoBean {

  @EJB
  private ClassificacaoDAO dao;

  private Classificacao classificacao;
  private LazyDataModel<Classificacao> classificacoes;
  private List<Classificacao> list;

  @PostConstruct
  public void init() {
    classificacao = new Classificacao();
  }

  public Classificacao getClassificacao() {
    return classificacao;
  }

  public void setClassificacao(Classificacao classificacao) {
    this.classificacao = classificacao;
  }

  public LazyDataModel<Classificacao> getClassificacoes() {
    try {
      if (classificacoes == null) {
        classificacoes = new Paginacao<Classificacao, ClassificacaoDAO>(dao);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return classificacoes;
  }

  public void setClassificacoes(LazyDataModel<Classificacao> deptos) {
    this.classificacoes = deptos;
  }

  public String actionSalvar() {
    try {
      if (classificacao.getId() == null) {
        dao.insert(classificacao);
      } else {
        classificacao = dao.update(classificacao);
      }
      classificacoes = null;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public String actionExcluir() {
    try {
      dao.remove(classificacao);
      classificacoes = null;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public List<Classificacao> getList() {
    if (list == null) {
      try {
        list = dao.listAll();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return list;
  }

  public void setList(List<Classificacao> list) {
    this.list = list;
  }

  public List<Classificacao> autoComplete(String query) {
    return dao.autoComplete(query);
  }
}
