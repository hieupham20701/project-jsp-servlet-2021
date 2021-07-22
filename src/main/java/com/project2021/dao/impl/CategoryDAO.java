package com.project2021.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project2021.dao.ICategoryDAO;
import com.project2021.model.CategoryModel;

public class CategoryDAO implements ICategoryDAO {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/projectservlet2021";
			String user = "root";
			String password = "sapassword";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public List<CategoryModel> findAll() {
		List<CategoryModel> results = new ArrayList<CategoryModel>();
		Connection con = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql= "Select * from category";
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setId(rs.getLong("id"));
				category.setName(rs.getString("name"));
				category.setCode(rs.getString("code"));
				results.add(category);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}finally {
			try {
				con.close();
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return results;
	}

}
