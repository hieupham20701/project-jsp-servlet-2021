package com.project2021.dao.impl;

import java.util.List;

import com.project2021.dao.ICategoryDAO;
import com.project2021.mapper.CategoryMapper;
import com.project2021.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {
	
	@Override
	public List<CategoryModel> findAll() {
		String sql= "Select * from category";
		return query(sql, new CategoryMapper());
	}

}
