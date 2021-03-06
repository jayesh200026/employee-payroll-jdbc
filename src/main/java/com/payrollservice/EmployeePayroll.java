package com.payrollservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	 * @return true if update is successful
	 */
	public boolean updateSalary() {
		Employee emp = new Employee();
		emp.setSalary(300000.0);
		try {
			Connection connection = makeConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate("update employee_payroll set salary=300000 where name='Terisa'");
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

	/**
	 * @return true if update is successful Uses prepared statement
	 */
	public boolean updateSalaryPrepared() {
		Employee emp = new Employee();
		emp.setSalary(300000.0);
		try {
			Connection connection = makeConnection();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = connection
					.prepareStatement("update employee_payroll set salary=? where name=?");
			preparedStatement.setDouble(1, 300000);
			preparedStatement.setString(2, "Terisa");
			preparedStatement.executeUpdate();
			ResultSet resultSet = statement.executeQuery("select salary from employee_payroll where name='Terisa'");
			while (resultSet.next()) {
				System.out.println(resultSet.getDouble(1));
				if (resultSet.getDouble(1) == emp.getSalary()) {
					return true;
				}
			}
			return false;

		} catch (ClassNotFoundException | SQLException e) {
			return false;
		}

	}

	public boolean displayDataPrepared(String name) {
		Connection connection;

		try {
			connection = makeConnection();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from employee_payroll where name=?");
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
						+ " " + resultSet.getDouble(4) + " " + resultSet.getDate(5));
			}
			return true;

		} catch (ClassNotFoundException | SQLException e) {
			return false;
		}

	}

	public boolean displayBasedOnDate() {
		try {
			Connection connection = makeConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(
					"select * from employee_payroll where start BETWEEN CAST('2019-01-01' AS DATE) AND DATE(NOW())");
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
	 * Gets the total salary from employee based on their gender
	 */
	public void getTotalSalary() {
		try {
			Connection connection = makeConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select gender,sum(salary) from employee_payroll group by gender");
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + "  " + resultSet.getDouble(2));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Gets the average salary from employee based on their gender
	 */

	public void getAverageSalary() {
		try {
			Connection connection = makeConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select gender,avg(salary) from employee_payroll group by gender");
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + "  " + resultSet.getDouble(2));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Gets the maximum salary from employee based on their gender
	 */
	public void getMaximumSalary() {

		try {
			Connection connection = makeConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select gender,max(salary) from employee_payroll group by gender");
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + "  " + resultSet.getDouble(2));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Gets the minimum salary from employee based on their gender
	 */
	public void getMinimumSalary() {
		try {
			Connection connection = makeConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select gender,min(salary) from employee_payroll group by gender");
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + "  " + resultSet.getDouble(2));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Gets the employee count based on gender
	 */
	public void getEmployeeCount() {
		try {
			Connection connection = makeConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select gender,count(*) from employee_payroll group by gender");
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + "  " + resultSet.getInt(2));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public boolean getInsertEmployee() {
		Connection connection;
		try {
			connection = makeConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate(
					"insert into employee_payroll(name,gender,salary,start) values('Bruce','M',550000.00,'2019-05-20')");
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			return false;

		}

	}
}
