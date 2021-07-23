package com.project2021.dao;

import java.util.List;

import com.project2021.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {
	List<CategoryModel> findAll();
}
