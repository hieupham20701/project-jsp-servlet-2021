package com.project2021.dao.impl;

import java.util.List;
import com.project2021.dao.INewDAO;
import com.project2021.mapper.NewMapper;
import com.project2021.model.NewModel;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {
	
	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		String sql= "Select * from news where categoryid = ?";
		return query(sql, new NewMapper(),categoryId);
	}

}
