package com.nisum.dao;

import java.util.List;

import com.nisum.employee.Employee;

public interface EmployeeDao {
	String saveEmployee(Employee e);
	String updateEmployee(Employee e);
	String deleteEmployee(int eid);
	List<Employee> getAllEmployee();
	List<Employee> getByEid(Integer eid);
}
