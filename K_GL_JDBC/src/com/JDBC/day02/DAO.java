package com.JDBC.day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAO {

	// insert update delete ���������԰�������
	public void update(String sql, Object... args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.relesaeDB(null, preparedStatement, connection);
		}

	}

	// ��ѯһ����¼�����ض�Ӧ�Ķ���
	public <T> T get(Class<T> clazz, String sql, Object... args) {
		// 1.��ȡConnection
		// 2.��ȡPreparedStatement
		// 3.���ռλ��
		// 4.���в�ѯ���õ�ReusltSet
		// 5.��ReusltSet���м�¼��׼��һ��Map<String , Object>����������еı��� ֵ����ŵ���ֵ
		// 6.�õ�ResultSetMetaData����
		// 7.����ResultSet����ָ�������ƶ�һ����λ
		// 8.��ResultSetMetaData����õ���������ж�����
		// 9.��ResultSetMetaData�õ�ÿһ�еı�������ResultSet�õ�����ÿһ�е�ֵ
		// 10.���Map����
		// 11.�÷��䴴��Class��Ӧ�Ķ���
		// 12.����Map�����÷��������������ֵ��������ΪMap�е�key������ֵΪMap�е�value
		T entity = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// 1.
			connection = JDBCTools.getConnection();
			// 2.
			preparedStatement = connection.prepareStatement(sql);
			// 3.
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			// 4.
			resultSet = preparedStatement.executeQuery();
			// 5.
			if (resultSet.next()) {
				Map<String, Object> values = new HashMap<String, Object>();
				// 6.
				ResultSetMetaData rsmd = resultSet.getMetaData();
				// 7.8
				int columnCount = rsmd.getColumnCount();
				// 9.
				for (int i = 0; i < columnCount; i++) {
					String columnLable = rsmd.getColumnLabel(i + 1);
					Object columnValue = resultSet.getObject(i + 1);
					// 10.
					values.put(columnLable ,columnValue );
				}
				// 11.
				entity = clazz.newInstance();
				// 12.
				for (Map.Entry<String, Object>  entry : values.entrySet()) {
					String propertyName = entry.getKey();
					Object value = entry.getValue();

					ReflectionUtils.setFieldValue(entity, propertyName, value);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.relesaeDB(resultSet, preparedStatement, connection);
		}
		return entity;
	}

	// ��ѯ������¼�����ض�Ӧ�Ķ��󼯺�
	public <T> List<T> getForList(Class<T> clazz, String sql, Object... ages) {
		return null;
	}

	// ����ĳ����¼��ĳһ���ֶε�ֵ��һ��ͳ�Ƶ�ֵ
	public <E> E getForValue(String sql, Object... args) {
		return null;
	}

}
