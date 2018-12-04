package com.nisum.employee;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRetrived implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Employee e = new Employee();
		e.setEid(rs.getInt(1));
		e.setEname(rs.getString(2));
		e.setEsal(rs.getFloat(3));
		return e;
	}

}
