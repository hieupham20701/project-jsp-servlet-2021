package com.project2021.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project2021.model.NewModel;

public class NewMapper implements RowMapper<NewModel> {

	@Override
	public NewModel mapRow(ResultSet rs) {
		try {
			NewModel news = new NewModel();
			news.setId(rs.getLong("id"));
			news.setTitle(rs.getString("title"));
			news.setContent(rs.getString("content"));
			news.setCategoryId(rs.getLong("categoryId"));
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
