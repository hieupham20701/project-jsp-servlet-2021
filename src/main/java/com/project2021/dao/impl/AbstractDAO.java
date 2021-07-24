package com.project2021.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.project2021.dao.GenericDAO;
import com.project2021.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {
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
	public List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> result = new ArrayList<T>();
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameter(stmt, parameters);
			rs = stmt.executeQuery();
			while(rs.next()) {
				result.add(rowMapper.mapRow(rs));
			}
			return result;
		} catch (SQLException e) {
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
	private void setParameter(PreparedStatement stmt,Object... parameters ) {
		try {
			for(int i=0;i< parameters.length;i++) {
				Object parameter = parameters[i];
				int index = i+1;
				if(parameter instanceof Long) {
					stmt.setLong(index, (Long) parameter);
				}else if(parameter instanceof String){
					stmt.setString(index, (String) parameter);
				}else if(parameter instanceof Integer) {
					stmt.setInt(index, (Integer) parameter);
				}else if (parameter instanceof Timestamp) {
					stmt.setTimestamp(index,(Timestamp) parameter);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection con = null;
		PreparedStatement stmt =  null;
		try {
			 con = getConnection();
			 con.setAutoCommit(false);
			 stmt = con.prepareStatement(sql);
			 setParameter(stmt, parameters);
			 stmt.executeUpdate();
			 con.commit();
			 
		} catch (SQLException e) {
			// TODO: handle exception
			if(con != null) {
				try {
					con.rollback();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		
		}finally {
			try {
				if(con!=null) {
					con.close();
				}
				if(stmt!=null) {
					stmt.close();
				}

			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		ResultSet rs =null;
		Connection con = null;
		PreparedStatement stmt =  null;
		try {
			 Long id  = null;
			 con = getConnection();
			 con.setAutoCommit(false);
			 stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			 setParameter(stmt, parameters);
			 stmt.executeUpdate();
			 rs = stmt.getGeneratedKeys();
			 if(rs.next()) {
				 id = rs.getLong(1);
			 }
			 con.commit();
			 return id;
		} catch (SQLException e) {
			// TODO: handle exception
			if(con != null) {
				try {
					con.rollback();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		
		}finally {
			try {
				if(con!=null) {
					con.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				if(rs != null) {
					rs.close();
				}

			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return null;

	}


}
