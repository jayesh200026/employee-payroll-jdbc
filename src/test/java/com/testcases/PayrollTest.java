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

	@Test
	public void whenConnectedToDatabase_forUpdatingData_returnsTrue() {
		EmployeePayroll emp = new EmployeePayroll();
		boolean result = emp.updateSalary();
		Assert.assertTrue("true", result);
	}

	@Test
	public void whenExecutedPreparredStatement_forUpdatingData_returnsTrue() {
		EmployeePayroll emp = new EmployeePayroll();
		boolean result = emp.updateSalaryPrepared();
		Assert.assertTrue("true", result);
	}
	
	@Test
	public void whenExecutedPreparredStatement_forDisplayingData_returnsTrue() {
		EmployeePayroll emp = new EmployeePayroll();
		boolean result = emp.displayDataPrepared("Terisa");
		Assert.assertTrue("true", result);
	}

}
