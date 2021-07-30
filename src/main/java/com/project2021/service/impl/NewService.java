package com.project2021.service.impl;

import java.sql.Timestamp;
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
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		newModel.setCreatedBy("");
		Long newId = newDAO.save(newModel);
		return newDAO.findOne(newId);
	}
	@Override
	public NewModel update(NewModel updateNew) {
		NewModel oldNew = newDAO.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updateNew.setModifiedBy("");
		newDAO.update(updateNew);
		return newDAO.findOne(updateNew.getId());
	}
	@Override
	public void delete(long [] ids) {
		for(long id : ids) {
			newDAO.delete(id);
		}
		
	}
	@Override
	public List<NewModel> findAll(Integer offset, Integer limit) {
		return newDAO.findAll(offset,limit);
	}
	@Override
	public int getTotalItem() {
		return newDAO.getTotalItem();
	}
	
}
