/**
 * 
 */
package com.designpatterns.singleton.usingreflectiontodestroy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rajs1
 *
 */
public class JDBCSingleton {
	
	//Using Reflection to destroy Singleton Pattern
	private static final JDBCSingleton instance = new JDBCSingleton();
	
	//private constructor to avoid client applications to use constructor
	private JDBCSingleton() {
		// TODO Auto-generated constructor stub
	}
	
	public static JDBCSingleton getInstance() {
		return instance;
	}
	
	private static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		return con;
	}
	
	public int insert(String empId, String empName, String empCity, int empSalary){
		int updatedCount = 0;
		Connection connection = null;
		PreparedStatement pStmt = null;
		try {
			connection = JDBCSingleton.getConnection();
			pStmt = connection.prepareStatement("insert into emp_test(emp_id,emp_name,emp_city,emp_salary) values(?,?,?,?)");
			int i = 0;
			pStmt.setString(++i, empId);
			pStmt.setString(++i, empName);
			pStmt.setString(++i, empCity);
			pStmt.setInt(++i, empSalary);
			updatedCount = pStmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				pStmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return updatedCount;
	}
	
	
	public List<Map<String, Object>> view(String empId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Map<String, Object> map = null;
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		con = JDBCSingleton.getConnection();
		preparedStatement = con.prepareStatement("select emp_id,emp_name,emp_city,emp_salary from emp_test where emp_id = ?");
		int i=0;
		preparedStatement.setString(++i, empId);
		resultSet = preparedStatement.executeQuery();
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		while(resultSet.next()){
			map = new HashMap<>();
			map.put("id", resultSet.getString("emp_id"));
			map.put("name", resultSet.getString("emp_name"));
			map.put("city", resultSet.getString("emp_city"));
			map.put("salary", resultSet.getInt("emp_salary"));
			list.add(map);
		}
		return list;
	}
}
