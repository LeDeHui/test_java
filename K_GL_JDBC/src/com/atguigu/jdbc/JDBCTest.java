package com.atguigu.jdbc;

import java.util.Scanner;

import org.junit.Test;

public class JDBCTest {
	@Test
	public void testGetStrdent() {
		//1.�õ���ѯ����
		int searchTypt = getSearchTypeFromConslie();

		//2.�����ѯѧ����Ϣ
		Student student = searchStudent(searchTypt);

		//3.��ӡѧ����Ϣ
		printStudent(student);

	}

	/**
	 * ��ӡѧ����Ϣ  ���������ӡ�������Ϣ
	 * 	�������ڴ�ӡ:���޴���
	 */
	private void printStudent(Student student) {
		// TODO Auto-generated method stub

	}

	/**
	 * �����ѯѧ����Ϣ,����һ��Student����,����ѷ�ڷ���null
	 */
	private Student searchStudent(int searchTypt) {
		 
		
		
		return null;
	}

	/**
	 * �ӿ���̨����һ������,ȷ��Ҫ��ѯ������ return 1>���֤ 2>׼��֤��ѯ ������Ч,�����Ѵ�������
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
	 * �ӿ���̨����ѧ������Ϣ
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
		// 1. ׼��һ�� SQL ���:
		String sql = "INSERT INTO student" + "(FLOWID, TYPE, IDCARD, EXAMCARD, STUDENRNAME, LOCALHOST, GRADE) "
				+ "VALUES(" + student.getFlowId() + "," + student.getType() + ",'" + student.getIdCard() + "','"
				+ student.getExamCard() + "','" + student.getStudentName() + "','" + student.getLocation() + "',"
				+ student.getGrade() + ")";

		System.out.println(sql);

		// 2. ���� JDBCTools ��� update(sql) ����ִ�в������.
		JDBCTools.update(sql);
	}

}
