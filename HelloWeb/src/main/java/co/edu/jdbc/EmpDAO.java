package co.edu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class EmpDAO {
	
	Connection conn;
	public void connect() {
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "hr", "hr");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Map<String,Object> getEmpInfo(int empId){
		
		connect();
		String sql = "select * from employees where employee_id =?";
		Map<String, Object> result = new HashMap<>();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				result.put("id", rs.getInt("employee_id"));
				result.put("Name" , rs.getString("first_name") + " " +rs.getString("last_name"));
				result.put("salary", rs.getInt("salary"));
				result.put("departmentId",rs.getInt("department_id"));
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Map<String, Object> inputEmpInfo(){
		connect();
		String sql = "INSERT INTO employees (employee_id, first_name, last_name, hire_date, job_id, email )\r\n"
				+ "VALUES(?,?,?,?,?,?)";
		Map<String, Object> result = new HashMap<>();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
}
