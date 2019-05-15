package com.atguigu.jdbc;

import java.util.Scanner;

import org.junit.Test;

public class JDBCTest {
	@Test
	public void testGetStrdent() {
		//1.得到查询类型
		int searchTypt = getSearchTypeFromConslie();

		//2.具体查询学生信息
		Student student = searchStudent(searchTypt);

		//3.打印学生信息
		printStudent(student);

	}

	/**
	 * 打印学生信息  若存在则打印其具体信息
	 * 	若不存在打印:查无此人
	 */
	private void printStudent(Student student) {
		// TODO Auto-generated method stub

	}

	/**
	 * 具体查询学生信息,返回一个Student对象,若不逊在返回null
	 */
	private Student searchStudent(int searchTypt) {
		 
		
		
		return null;
	}

	/**
	 * 从控制台读入一个整数,确定要查询的类型 return 1>身份证 2>准考证查询 其他无效,并提醒从新输入
	 */
	private int getSearchTypeFromConslie() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Test
	public void testAddNewStudent() {
		Student student = getStudentFromConsole();
		addNewStudent(student);
	}

	/**
	 * 从控制台输入学生的信息
	 */
	private Student getStudentFromConsole() {

		Scanner scanner = new Scanner(System.in);

		Student student = new Student();

		System.out.print("FlowId:");
		student.setFlowId(scanner.nextInt());

		System.out.print("Type: ");
		student.setType(scanner.nextInt());

		System.out.print("IdCard:");
		student.setIdCard(scanner.next());

		System.out.print("ExamCard:");
		student.setExamCard(scanner.next());

		System.out.print("StudentName:");
		student.setStudentName(scanner.next());

		System.out.print("Location:");
		student.setLocation(scanner.next());

		System.out.print("Grade:");
		student.setGrade(scanner.nextInt());

		return student;
	}

//	public void addNewStudent2(Student student) {
//		String sql = "INSERT INTO examstudent(flowid, type, idcard, "
//				+ "examcard, studentname, location, grade) "
//				+ "VALUES(?,?,?,?,?,?,?)";
//
//		JDBCTools.update(sql, student.getFlowId(), student.getType(),
//				student.getIdCard(), student.getExamCard(),
//				student.getStudentName(), student.getLocation(),
//				student.getGrade());
//	}

	public void addNewStudent(Student student) {
		// 1. 准备一条 SQL 语句:
		String sql = "INSERT INTO student" + "(FLOWID, TYPE, IDCARD, EXAMCARD, STUDENRNAME, LOCALHOST, GRADE) "
				+ "VALUES(" + student.getFlowId() + "," + student.getType() + ",'" + student.getIdCard() + "','"
				+ student.getExamCard() + "','" + student.getStudentName() + "','" + student.getLocation() + "',"
				+ student.getGrade() + ")";

		System.out.println(sql);

		// 2. 调用 JDBCTools 类的 update(sql) 方法执行插入操作.
		JDBCTools.update(sql);
	}

}
