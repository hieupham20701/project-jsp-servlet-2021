package com.project2021.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.project2021.dao.GenericDAO;

public class AbstractDAO implements GenericDAO {
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
}
