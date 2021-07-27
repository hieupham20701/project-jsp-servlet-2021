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
		Long newId = newDAO.save(newModel);
		return newDAO.findOne(newId);
	}
	@Override
	public NewModel update(NewModel updateNew) {
		NewModel oldNew = newDAO.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		newDAO.update(updateNew);
		return newDAO.findOne(updateNew.getId());
	}
	@Override
	public void delete(long [] ids) {
		for(long id : ids) {
			newDAO.delete(id);
		}
		
	}
	
}
