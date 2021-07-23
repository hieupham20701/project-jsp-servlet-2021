package com.project2021.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project2021.dao.INewDAO;
import com.project2021.model.CategoryModel;
import com.project2021.model.NewModel;

public class NewDAO extends AbstractDAO implements INewDAO {
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
	public List<NewModel> findByCategoryId(Long categoryId) {
		List<NewModel> results = new ArrayList<NewModel>();
		Connection con = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql= "Select * from news where categoryid = ?";
		if(con != null) {
			try {
				stmt = con.prepareStatement(sql);
				stmt.setLong(1, categoryId);
				rs = stmt.executeQuery();
				while(rs.next()) {
					NewModel news = new NewModel();
					news.setId(rs.getLong("id"));
					news.setTitle(rs.getString("title"));
					results.add(news);
				}
				return results;
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				return null;
			}finally {
				try {
					if(con!=null) {
						con.close();
					}
					if(stmt!=null) {
						stmt.close();
					}
					if(rs!=null) {
						rs.close();
					}
				} catch (SQLException e2) {
					return null;
				}
			}
		}
		return null;
	}

}
