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
			// 1. 得到 ResultSetMetaData 对象
			ResultSetMetaData rsmd = resultSet.getMetaData();
			while (resultSet.next()) {
				// 2. 打印每一列的列名
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
			//1.得到 ResultSet 对象
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			resultSet = preparedStatement.executeQuery();
			
			//2.得到ResultSetMetaDate 对象
			ResultSetMetaData  rsmd = resultSet.getMetaData();
			
			//3.创建一个map<String ，Object>对象，键：SQL查询的列的别名  值：列的值
			Map<String, Object> values = new HashMap< >();
			
			//4.处理结果集。利用 ResultSetMetaDate 填充3对应的map对象
			if (resultSet.next() ) {
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					String  columnLable = rsmd.getColumnLabel(i+1);
					Object columnValue = resultSet.getObject(i+1);
					values.put(columnLable, columnValue);
				}
			}
			//5.利用反射创建class1对象的对象
			if (values.size()>0) {
				entity = class1.newInstance();
				//6.遍历map对象，利用反射为Class对象的对应的属性赋值
				for (Map.Entry<String, Object> entry:values.entrySet()) {
					String fieldName  = entry.getKey();
					Object  value = entry.getValue();
					ReflectionUtils.setFieldValue(entity, fieldName, value);
				}
				
			}
			if (resultSet.next()) {
				// 利用反射创建对象
				entity = class1.newInstance();
				// 通过解析SQL语句来判断到底选择哪些列，以及需要为entity对象的哪些属性赋值

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
		// 1.得到查询类型
		int searchTypt = getSearchTypeFromConslie();

		// 2.具体查询学生信息
		Student student = searchStudent(searchTypt);

		// 3.打印学生信息
		printStudent(student);

	}

	/**
	 * 打印学生信息 若存在则打印其具体信息 若不存在打印:查无此人
	 */
	private void printStudent(Student student) {
		if (student != null) {
			System.out.println(student);
		} else {
			System.out.println("查无此人");
		}
	}

	/**
	 * 具体查询学生信息,返回一个Student对象,若不逊在返回null
	 */
	private Student searchStudent(int searchTypt) {
		String sql = "select FLOWID, TYPE, IDCARD, EXAMCARD, STUDENRNAME, LOCALHOST, GRADE " + "from student "
				+ "where ";
		Scanner scanner = new Scanner(System.in);
		// 1.根据输入的searchType，提示用户输入信息
		// 1.1 若searchType 为1 ：提示输入身份证 为2 提示输入准考证号
		// 2.根据searchType 确定sql
		if (searchTypt == 1) {
			System.out.print("请输入身份证号");
			String idCard = scanner.next();
			sql = sql + " idCArd = '" + idCard + "'";
		} else {
			System.out.print("请输入准考证号");
			String exmcCard = scanner.next();
			sql = sql + " idCArd = '" + exmcCard + "'";
		}
		// 3.执行SQL
		Student student = getStudent(sql);

		// 4.若存在查询结果，把查询结果封装为一个student对象

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
	 * 根据传入的SQL 返回Student 对象
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
	 * 从控制台读入一个整数,确定要查询的类型 return 1>身份证 2>准考证查询 其他无效,并提醒从新输入
	 */
	private int getSearchTypeFromConslie() {
		System.out.println("请输入查询类型:1 身份证查询 	2 准考证查询");
		Scanner scanner = new Scanner(System.in);
		int type = scanner.nextInt();
		if (type != 1 && type != 2) {
			System.out.println("输入有误,结束输入");
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

	public void addNewStudent2(Student student) {
		String sql = "INSERT INTO student" + "(FLOWID, TYPE, IDCARD, " + "EXAMCARD, STUDENRNAME," + " LOCALHOST, GRADE)"
				+ "VALUES(?,?,?,?,?,?,?)";

		JDBCTools.update(sql, student.getFlowId(), student.getType(), student.getIdCard(), student.getExamCard(),
				student.getStudentName(), student.getLocation(), student.getGrade());
	}

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
