/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.pgn0079.toreba.model.dao.impl;

import br.estacio.pgn0079.toreba.model.dao.GenericDAO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.ejb.EntityManagerImpl;

/**
 *
 * @author michel
 */
public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

  @PersistenceContext
  protected EntityManager em;

  private Class<T> persistenceClass;
  private String namedQuery;
  private String autoComplete;

  public GenericDAOImpl(Class<T> persistenceClass, String namedQuery, String autoComplete) {
    this.persistenceClass = persistenceClass;
    this.namedQuery = namedQuery;
    this.autoComplete = autoComplete;
  }

  @Override
  public void insert(T obj) throws Exception {
    try {
      em.persist(obj);
    } catch (Exception e) {
      throw e;
    }
  }

  @Override
  public T update(T obj) throws Exception {
    try {
      obj = em.merge(obj);
    } catch (Exception e) {
      throw e;
    }
    return obj;
  }

  @Override
  public boolean remove(T obj) throws Exception {
    try {
      obj = em.merge(obj);
      em.remove(obj);
    } catch (Exception e) {
      throw e;
    }
    return true;
  }

  @Override
  @TransactionAttribute(TransactionAttributeType.SUPPORTS)
  public T find(Long id) throws Exception {
    try {
      return em.find(persistenceClass, id);
    } catch (Exception e) {
      throw e;
    }
  }

  @Override
  @TransactionAttribute(TransactionAttributeType.SUPPORTS)
  public List<T> listAll() throws Exception {
    try {
      TypedQuery<T> query = em.createNamedQuery(namedQuery, persistenceClass);
      return query.getResultList();
    } catch (Exception e) {
      throw e;
    }
  }

  @Override
  public List<T> queryByExample(T obj) throws Exception {
    try {
      Session session;
      if (em.getDelegate() instanceof EntityManagerImpl) {
        EntityManagerImpl entityManagerImpl = (EntityManagerImpl) em.getDelegate();
        session = entityManagerImpl.getSession();
      } else {
        session = (Session) em.getDelegate();
      }
      Example qbe = Example.create(obj)
        .ignoreCase()
        .enableLike(MatchMode.ANYWHERE);
      Criteria criteria = session.createCriteria(persistenceClass).add(qbe);
      criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
      List<T> list = criteria.list();
      return list;
    } catch (Exception e) {
      throw e;
    }
  }

  @Override
  @TransactionAttribute(TransactionAttributeType.SUPPORTS)
  public List<T> listAll(int first, int pageSize) throws Exception {
    try {
      TypedQuery<T> query = em.createNamedQuery(namedQuery, persistenceClass);
      return query
        .setFirstResult(first)
        .setMaxResults(pageSize)
        .getResultList();
    } catch (Exception e) {
      throw e;
    }
  }

    @Override
  public int getQtdeRecords() {
    long result = 0;
    try {
      CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
      CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
      Root<T> obj = criteriaQuery.from(persistenceClass);
      criteriaQuery.select(criteriaBuilder.count(obj.get("id")));
      result = em.createQuery(criteriaQuery).getSingleResult();
      em.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return (int) result;
  }

  @Override
  public List<T> autoComplete(String query) {
    try {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<T> cq = cb.createQuery(persistenceClass);
      Root<T> obj = cq.from(persistenceClass);
      cq.where(cb.like(cb.upper(obj.get(autoComplete).as(String.class)), 
        "%" + query.toUpperCase() + "%"));
      cq.orderBy(cb.asc(obj.get(autoComplete)));
      return em.createQuery(cq).getResultList();
    } catch (NoResultException e) {
      return new ArrayList<T>();
    }
  }
  
}
