package com.project2021.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.project2021.dao.ICategoryDAO;
import com.project2021.model.CategoryModel;
import com.project2021.service.ICategoryService;

public class CategoryService implements ICategoryService {
	
	@Inject
	private ICategoryDAO categoryDao;

	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}
}
