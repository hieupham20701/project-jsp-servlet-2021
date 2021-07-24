package com.project2021.dao;

import java.util.List;

import com.project2021.model.NewModel;

public interface INewDAO extends GenericDAO<NewModel>{
	List<NewModel> findByCategoryId(Long categoryId);
	Long save(NewModel newModel);
}
