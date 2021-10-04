package com.payrollservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeePayroll {
	private static String url = "jdbc:mysql://localhost:3306/";
	private static String userName = "root";
	private static String password = "thor@Mysql";

	public EmployeePayroll(String database) {
		this.url = this.url + database;
	}

	public boolean getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, userName, password);
			System.out.println("Connected");
			con.close();
			return true;

		}

		catch (ClassNotFoundException | SQLException e) {
			return false;

		}

	}

}
