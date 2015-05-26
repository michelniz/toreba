/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.pgn0079.toreba.model.controll;

import br.estacio.pgn0079.toreba.model.dao.GenericDAO;
import br.estacio.pgn0079.toreba.model.entity.GenericEntity;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author michel
 */
public class Paginacao<T extends GenericEntity, D extends GenericDAO<T>> extends LazyDataModel<T> {

  private D dao;
  private List<T> result;

  public Paginacao(D dao) {
    this.dao = dao;
  }

  @Override
  public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
    try {
      result = dao.listAll(first, pageSize);
      if (getRowCount() <= 0) {
        setRowCount(dao.getQtdeRecords());
      }
      setPageSize(pageSize);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public Object getRowKey(T obj) {
    return obj.getId();
  }

  @Override
  public T getRowData(String id) {
    Long idObj = Long.valueOf(id);

    for (T obj : result) {
      if (idObj.equals(obj.getId())) {
        return obj;
      }
    }
    return null;
  }

}
