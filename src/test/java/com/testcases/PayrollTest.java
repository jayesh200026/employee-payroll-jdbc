package com.testcases;

import org.junit.Assert;
import org.junit.Test;

import com.payrollservice.EmployeePayroll;

public class PayrollTest {

	@Test
	public void whenConnectedToDatabase_withCorrectCredentials_returnsTrue() {
		EmployeePayroll emp = new EmployeePayroll("employe_payroll");
		boolean result = emp.getConnection();
		Assert.assertTrue("true", result);
	}

	@Test
	public void whenConnectedToDatabase_withInCorrectCredentials_returnsTrue() {
		EmployeePayroll emp = new EmployeePayroll("employepayroll");
		boolean result = emp.getConnection();
		Assert.assertFalse("false", result);
	}

}
