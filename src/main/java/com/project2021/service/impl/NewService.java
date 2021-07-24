package com.project2021.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.project2021.dao.INewDAO;
import com.project2021.model.NewModel;
import com.project2021.service.INewService;



public class NewService implements INewService {

	@Inject
	private INewDAO newDAO;
	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		return newDAO.findByCategoryId(categoryId);
	}
	@Override
	public NewModel save(NewModel newModel) {
		// TODO Auto-generated method stub
		Long newId = newDAO.save(newModel);
		System.out.println(newId);
		return null;
	}
	



}
