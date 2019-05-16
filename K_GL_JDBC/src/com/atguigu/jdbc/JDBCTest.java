package com.atguigu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;
 
 

public class JDBCTest {
	@Test
	public void testResultSetMetaData() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String sql = "SELECT flowId flowId, type type, idcard idCard, "
					+ "examcard examCard, studenrname studentName, " 
					+ "localhost location, grade  grade "
					+ "FROM student WHERE flowid = ?";
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 11);
			resultSet = preparedStatement.executeQuery();
			Map<String, Object> values =  new HashMap<String, Object>();
			// 1. �õ� ResultSetMetaData ����
			ResultSetMetaData rsmd = resultSet.getMetaData();
			while (resultSet.next()) {
				// 2. ��ӡÿһ�е�����
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					String columnLabel = rsmd.getColumnLabel(i + 1);
					Object columnValue  = resultSet.getObject(columnLabel);
					 values.put(columnLabel,columnValue );
				}
			}
			//System.out.println(values);
			
			Class class1 = Student.class;
			Object object = class1.newInstance();
			for ( Map.Entry<String, Object >  entry: values.entrySet()) {
				String fieldName = entry.getKey();
				Object fieldValue = entry.getValue();
				//System.out.println(fieldName+ " : "+fieldValue);
				ReflectionUtils.setFieldValue(object, fieldName	, fieldValue);
			}
			//System.out.println(object);
			 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.relesaeDB(resultSet, preparedStatement, connection);
		}

	}

	@Test
	public void testGet() {
		String sql = "select id,name,email,birth from costomer where id = ?";
		Customer customer = get(Customer.class, sql, 5);
		System.out.println(sql);
		System.out.println(customer);
		sql = "SELECT flowid flowId, type, idcard idCard, " + "examcard examCard, studenrname studentName, "
				+ "localhost, grade " + "FROM student WHERE flowid = ?";
		System.out.println(sql);

		Student stu = get(Student.class, sql, 5);
		System.out.println(stu);
	}
	 

	public <T> T get(Class<T> class1, String sql, Object... args) {
		T entity = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			//1.�õ� ResultSet ����
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			resultSet = preparedStatement.executeQuery();
			
			//2.�õ�ResultSetMetaDate ����
			ResultSetMetaData  rsmd = resultSet.getMetaData();
			
			//3.����һ��map<String ��Object>���󣬼���SQL��ѯ���еı���  ֵ���е�ֵ
			Map<String, Object> values = new HashMap< >();
			
			//4.�������������� ResultSetMetaDate ���3��Ӧ��map����
			if (resultSet.next() ) {
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					String  columnLable = rsmd.getColumnLabel(i+1);
					Object columnValue = resultSet.getObject(i+1);
					values.put(columnLable, columnValue);
				}
			}
			//5.���÷��䴴��class1����Ķ���
			if (values.size()>0) {
				entity = class1.newInstance();
				//6.����map�������÷���ΪClass����Ķ�Ӧ�����Ը�ֵ
				for (Map.Entry<String, Object> entry:values.entrySet()) {
					String fieldName  = entry.getKey();
					Object  value = entry.getValue();
					ReflectionUtils.setFieldValue(entity, fieldName, value);
				}
				
			}
			if (resultSet.next()) {
				// ���÷��䴴������
				entity = class1.newInstance();
				// ͨ������SQL������жϵ���ѡ����Щ�У��Լ���ҪΪentity�������Щ���Ը�ֵ

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.relesaeDB(resultSet, preparedStatement, connection);
		}

		return null;
	}

	@Test
	public void testPrepardeStatemen() {
		// 1.
		Connection connection = null;
		PreparedStatement ps = null;

		// 2.
		try {
			connection = JDBCTools.getConnection();
			String sql = "insert into student (FLOWID, TYPE, IDCARD, EXAMCARD, STUDENRNAME, LOCALHOST, GRADE) "
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
		} finally {
			JDBCTools.relesaeDB(null, ps, connection);
		}
		// 3.

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
		if (student != null) {
			System.out.println(student);
		} else {
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

	public Customer getCustomer(String sql, Object... args) {
		Customer customer = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				// stu = new Student();
				// stu.setFlowId(resultSet.getInt(1));
				// stu.setType(resultSet.getInt(2));
				// stu.setIdCard(resultSet.getString(3));

				customer = new Customer();
				customer.setId(resultSet.getInt(1));
				customer.setName(resultSet.getString(2));
				customer.setEmail(resultSet.getString(3));
				customer.setBirth(resultSet.getDate(4));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.relesaeDB(resultSet, preparedStatement, connection);
		}

		return customer;
	}

	/**
	 * ���ݴ����SQL ����Student ����
	 */
	private Student getStudent(String sql) {
		Student student = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCTools.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				student = new Student(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
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
		String sql = "INSERT INTO student" + "(FLOWID, TYPE, IDCARD, " + "EXAMCARD, STUDENRNAME," + " LOCALHOST, GRADE)"
				+ "VALUES(?,?,?,?,?,?,?)";

		JDBCTools.update(sql, student.getFlowId(), student.getType(), student.getIdCard(), student.getExamCard(),
				student.getStudentName(), student.getLocation(), student.getGrade());
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
