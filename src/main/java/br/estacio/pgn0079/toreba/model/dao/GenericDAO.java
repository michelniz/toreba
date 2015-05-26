/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.pgn0079.toreba.model.dao;

import java.util.List;

/**
 *
 * @author michel
 */
public interface GenericDAO<T> {
    
  public void insert(T obj) throws Exception;

  public T update(T obj) throws Exception;

  public boolean remove(T obj) throws Exception;

  public T find(Long id) throws Exception;

  public List<T> listAll() throws Exception;

  public List<T> queryByExample(T obj) throws Exception;

  public List<T> listAll(int first, int pageSize) throws Exception;

  public int getQtdeRecords();
  
  public List<T> autoComplete(String query);
    
}
