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

	@Test
	public void whenExecutedQuery_forDisplayingDataBasedOnJoiningDate_returnsTrue() {
		EmployeePayroll emp = new EmployeePayroll();
		boolean result = emp.displayBasedOnDate();
		Assert.assertTrue("true", result);
	}

	@Test
	public void whenExecutedQuery_toGetTotalSalaryBasedOnGender_returnsTrue() {
		EmployeePayroll emp = new EmployeePayroll();
		emp.getTotalSalary();

	}

	@Test
	public void whenExecutedQuery_toGetAverageSalaryBasedOnGender_returnsTrue() {
		EmployeePayroll emp = new EmployeePayroll();
		emp.getAverageSalary();

	}

	@Test
	public void whenExecutedQuery_toGetMaximumSalaryBasedOnGender_returnsTrue() {
		EmployeePayroll emp = new EmployeePayroll();
		emp.getMaximumSalary();

	}

	@Test
	public void whenExecutedQuery_toGetMinimumSalaryBasedOnGender_returnsTrue() {
		EmployeePayroll emp = new EmployeePayroll();
		emp.getMinimumSalary();

	}

	@Test
	public void whenExecutedQuery_toGetCountOfEmployeesBasedOnGender_returnsTrue() {
		EmployeePayroll emp = new EmployeePayroll();
		emp.getEmployeeCount();

	}

	@Test
	public void whenExecutedQuery_toInsertNewRow_returnsTrue() {
		EmployeePayroll emp = new EmployeePayroll();
		boolean result = emp.getInsertEmployee();
		Assert.assertTrue(result);

	}

}
