package com.boundaryadvert.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.boundaryadvert.dao.BoundaryAdvertDao;
import com.boundaryadvert.model.Matrix;
import com.boundaryadvert.service.BoundaryAdvertService;

@Service("BoundaryAdvertService")
@Transactional
public class BoundaryAdvertServiceImpl implements BoundaryAdvertService {

 @Autowired
 private BoundaryAdvertDao BoundaryAdvertDao;
 
@Override
public List<Matrix> getAllMatrices() {
	return BoundaryAdvertDao.getAllMatrices();
}

}