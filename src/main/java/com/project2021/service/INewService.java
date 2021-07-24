package com.project2021.service;

import java.util.List;import javax.enterprise.inject.New;

import com.project2021.model.NewModel;



public interface INewService {
	List<NewModel> findByCategoryId (Long categoryId);
	NewModel save(NewModel newModel);
	
}
