package com.testcases;

import org.junit.Assert;
import org.junit.Test;

import com.payrollservice.EmployeePayroll;

public class PayrollTest {

	@Test
	public void whenConnectedToDatabase_withCorrectCredentials_returnsTrue() {
		EmployeePayroll emp = new EmployeePayroll();
		boolean result = emp.getConnection();
		Assert.assertTrue("true", result);
	}
	
	@Test
	public void whenConnectedToDatabase_forretreivingData_returnsTrue() {
		EmployeePayroll emp = new EmployeePayroll();
		boolean result = emp.selectData();
		Assert.assertTrue("true", result);
	}

	

}
