package com.project2021.dao;

import java.util.List;

import com.project2021.mapper.RowMapper;


public interface GenericDAO <T> {
	List<T> query(String sql,RowMapper<T> rowMapper, Object... parameters);
	void update(String sql, Object... parameters);
	Long insert(String sql, Object... parameters);

}
