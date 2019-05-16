package com.JDBC.day02;

import java.sql.Date;
import org.junit.jupiter.api.Test;

class DAOTsst {
	DAO dao = new DAO();

	@Test
	void testUpdate() {
		String sql = "insert into  COSTOMER(id,name,email,birth)" + "values(?,?,?,?)";
		dao.update(sql, 7, "7xiaoming", "7xiaomi@163.com", new Date(new java.util.Date().getTime()));
	}

	@Test
	void testGet() {
		String sql = "select FLOWID flowid, TYPE type, IDCARD idcard, EXAMCARD examcard, STUDENRNAME studenrname, LOCALHOST localhost,grade grade  from student where STUDENRNAME = ? ";
		Student student = dao.get(Student.class, sql, "LEDEHUI");
		System.out.println(student);
	}

	@Test
	void testGetForList() {
		 
	}

	@Test
	void testGetForValue() {
		 
	}

}
