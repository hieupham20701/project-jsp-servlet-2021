package com.project2021.dao;

import java.util.List;

import com.project2021.mapper.RowMapper;


public interface GenericDAO <T> {
	<T> List<T> query(String sql,RowMapper<T> rowMapper, Object... parameters);
}
