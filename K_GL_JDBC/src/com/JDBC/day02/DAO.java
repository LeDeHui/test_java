package com.JDBC.day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAO {

	// insert update delete 操作都可以包含其中
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

	// 查询一条记录，返回对应的对象
	public <T> T get(Class<T> clazz, String sql, Object... args) {
		// 1.获取Connection
		// 2.获取PreparedStatement
		// 3.填充占位符
		// 4.进行查询，得到ReusltSet
		// 5.若ReusltSet中有记录，准备一个Map<String , Object>：减：存放列的别名 值：存放的列值
		// 6.得到ResultSetMetaData对象
		// 7.处理ResultSet，将指针向下移动一个单位
		// 8.由ResultSetMetaData对象得到结果集中有多少列
		// 9.由ResultSetMetaData得到每一列的别名，由ResultSet得到具体每一列的值
		// 10.填充Map对象
		// 11.用反射创建Class对应的对象
		// 12.遍历Map对象，用反射填充对象的属性值：属性名为Map中的key，属性值为Map中的value
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

	// 查询多条记录，返回对应的对象集合
	public <T> List<T> getForList(Class<T> clazz, String sql, Object... ages) {
		return null;
	}

	// 返回某条记录的某一个字段的值或一个统计的值
	public <E> E getForValue(String sql, Object... args) {
		return null;
	}

}
