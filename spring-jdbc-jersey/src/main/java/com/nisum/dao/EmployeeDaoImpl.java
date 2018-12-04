package com.nisum.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nisum.employee.Employee;
import com.nisum.employee.EmployeeRetrived;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String saveEmployee(Employee e) {
		// TODO Auto-generated method stub
		String query = "insert into employeedeatails values(" + e.getEid() + ",'" + e.getEname() + "'," + e.getEsal()
				+ ")";
		int save = jdbcTemplate.update(query);
		if (save > 0) {
			return "Record added Successfully";
		} else {
			return "Sorry ! record not added";
		}
	}

	@Override
	public String updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		String query = "update employeedeatails set ename='" + e.getEname() + "', esal=" + e.getEsal() + " where eid="
				+ e.getEid();
		int update = jdbcTemplate.update(query);
		if (update > 0) {
			return "Record updated Successfully";
		} else {
			return "Sorry ! record not updated";
		}
	}

	@Override
	public String deleteEmployee(int eid) {
		// TODO Auto-generated method stub
		System.out.println(eid);
		String query = "delete from employeedeatails where eid=" + eid;
		int delete = jdbcTemplate.update(query);
		if (delete > 0) {
			return "Record deleted Successfully";
		} else {
			return "Sorry ! record not deleted";
		}
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from employeedeatails", new EmployeeRetrived());
	}

	@Override
	public List<Employee> getByEid(Integer eid) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from employeedeatails where eid=" + eid, new EmployeeRetrived());
	}
}
