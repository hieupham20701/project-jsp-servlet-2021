package com.project2021.dao;

import java.util.List;import javax.enterprise.inject.New;

import com.project2021.model.NewModel;

public interface INewDAO extends GenericDAO<NewModel>{
	NewModel findOne(Long id);
	List<NewModel> findByCategoryId(Long categoryId);
	Long save(NewModel newModel);
	void update(NewModel updateNew);
	void delete(long id);
	List<NewModel> findAll(Integer offset, Integer limit);
	int getTotalItem();
	
}
