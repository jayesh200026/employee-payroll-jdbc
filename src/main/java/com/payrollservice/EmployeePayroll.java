package com.payrollservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeePayroll {
	private static String url = "jdbc:mysql://localhost:3306/employe_payroll";
	private static String userName = "root";
	private static String password = "thor@Mysql";
	
	private Connection makeConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, userName, password);
		System.out.println("Connected");
		return con;
	}

	public boolean getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, userName, password);
			System.out.println("Connected");
			con.close();
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			return false;
		}
	}

	public boolean selectData() {
		try {
			Connection connection = makeConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from employee_payroll");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
						+ " " + resultSet.getDouble(4) + " " + resultSet.getDate(5));
			}
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			return false;
		}

	}

	

}
