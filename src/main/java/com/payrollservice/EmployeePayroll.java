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

	/**
	 * @return true if update is successfull
	 */
	public boolean updateSalary() {
		Employee emp = new Employee();
		emp.setSalary(300000.0);
		try {
			Connection connection = makeConnection();
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate("update employee_payroll set salary=300000 where name='Terisa'");
			ResultSet resultSet = statement.executeQuery("select salary from employee_payroll where name='Terisa'");
			while (resultSet.next()) {
				if (resultSet.getDouble(1) == emp.getSalary()) {
					return true;
				}
			}
			return false;
		} catch (ClassNotFoundException | SQLException e) {
			return false;
		}
	}
}
