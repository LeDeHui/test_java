package com.atguigu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.junit.Test;

import oracle.net.aso.s;
 

public class JDBCTest {
	
	@Test
	public void   testPrepardeStatemen() {
		//1.
		Connection connection = null;
		PreparedStatement ps = null;
		
		//2.
		try {
			connection = JDBCTools.getConnection();
			String  sql = "insert into student (FLOWID, TYPE, IDCARD, EXAMCARD, STUDENRNAME, LOCALHOST, GRADE) "
					+ "values(?,?,?,?,?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, 11); 
			ps.setInt(2, 56);
			ps.setString(3, "360");
			ps.setString(4, "425");
			ps.setString(5, "yuanfang");
			ps.setString(6, "jiujiang");
			ps.setInt(7, 58);
			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			JDBCTools.relesaeDB(null, ps, connection);
		}
		//3.

	}
	
	@Test
	public void testGetStrdent() {
		// 1.�õ���ѯ����
		int searchTypt = getSearchTypeFromConslie();

		// 2.�����ѯѧ����Ϣ
		Student student = searchStudent(searchTypt);

		// 3.��ӡѧ����Ϣ
		printStudent(student);

	}

	/**
	 * ��ӡѧ����Ϣ ���������ӡ�������Ϣ �������ڴ�ӡ:���޴���
	 */
	private void printStudent(Student student) {
		if (student !=null) {
			System.out.println(student);
		}else {
			System.out.println("���޴���");
		}
	}

	/**
	 * �����ѯѧ����Ϣ,����һ��Student����,����ѷ�ڷ���null
	 */
	private Student searchStudent(int searchTypt) {
		String sql = "select FLOWID, TYPE, IDCARD, EXAMCARD, STUDENRNAME, LOCALHOST, GRADE " + "from student "
				+ "where ";
		Scanner scanner = new Scanner(System.in);
		// 1.���������searchType����ʾ�û�������Ϣ
		// 1.1 ��searchType Ϊ1 ����ʾ�������֤ Ϊ2 ��ʾ����׼��֤��
		// 2.����searchType ȷ��sql
		if (searchTypt == 1) {
			System.out.print("���������֤��");
			String idCard = scanner.next();
			sql = sql + " idCArd = '" + idCard + "'";
		} else {
			System.out.print("������׼��֤��");
			String exmcCard = scanner.next();
			sql = sql + " idCArd = '" + exmcCard + "'";
		}
		// 3.ִ��SQL
		Student student = getStudent(sql);

		// 4.�����ڲ�ѯ������Ѳ�ѯ�����װΪһ��student����

		return student;
	}

	/**
	 * ���ݴ����SQL ����Student ����
	 * */
	private Student getStudent(String sql) {
		Student student = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCTools.getConnection();
			statement = connection.createStatement();
			resultSet =statement.executeQuery(sql);
			if (resultSet.next()) {
				student = new Student(
						resultSet.getInt(1), 
						resultSet.getInt(2), 
						resultSet.getString(3), 
						resultSet.getString(4), 
						resultSet.getString(5), 
						resultSet.getString(6), 
						resultSet.getInt(7));				
			}			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCTools.relesaeDB(resultSet, statement, connection);
		}		
		return student;
	}

	/**
	 * �ӿ���̨����һ������,ȷ��Ҫ��ѯ������ return 1>���֤ 2>׼��֤��ѯ ������Ч,�����Ѵ�������
	 */
	private int getSearchTypeFromConslie() {
		System.out.println("�������ѯ����:1 ���֤��ѯ 	2 ׼��֤��ѯ");
		Scanner scanner = new Scanner(System.in);
		int type = scanner.nextInt();
		if (type != 1 && type != 2) {
			System.out.println("��������,��������");
			throw new RuntimeException();
		}
		return type;
	}

	@Test
	public void testAddNewStudent() {
		Student student = getStudentFromConsole();
		addNewStudent2(student);
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

	public void addNewStudent2(Student student) {
		String sql = "INSERT INTO student"
				+ "(FLOWID, TYPE, IDCARD, "
				+ "EXAMCARD, STUDENRNAME,"
				+ " LOCALHOST, GRADE)"
				+ "VALUES(?,?,?,?,?,?,?)";

		JDBCTools.update(sql, 
				student.getFlowId(), student.getType(),
				student.getIdCard(), student.getExamCard(),
				student.getStudentName(), student.getLocation(),
				student.getGrade());
	}

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
