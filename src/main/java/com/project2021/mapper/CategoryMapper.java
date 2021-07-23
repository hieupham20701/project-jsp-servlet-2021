package com.project2021.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project2021.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel> {

	@Override
	public CategoryModel mapRow(ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			CategoryModel category = new CategoryModel();
			category.setId(rs.getLong("id"));
			category.setName(rs.getString("name"));
			category.setCode(rs.getString("code"));
			return category;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
}
