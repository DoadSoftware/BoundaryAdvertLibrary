package com.boundaryadvert.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.boundaryadvert.dao.BoundaryAdvertDao;
import com.boundaryadvert.model.Matrix;

@Transactional
@Repository("BoundaryAdvertDao")
@SuppressWarnings("unchecked")
public class BoundaryAdvertDaoImpl implements BoundaryAdvertDao {

 @Autowired
 private SessionFactory sessionFactory;

@Override
public List<Matrix> getAllMatrices() {
	return sessionFactory.getCurrentSession().createQuery("FROM Matrix").list();
}
}