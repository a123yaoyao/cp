package com.cn.count;
import com.cn.count.model.CwrProject;

import javax.sql.RowSet;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCConnect {
	public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");//找到oracle驱动器所在的类

	}

	private static Connection connection;
	public static Connection getConnect(String url, String username, String password) {
		try {
			connection = DriverManager.getConnection(url, username,
					password);
		} catch (SQLException se) {
			System.out.println("数据库连接失败！");
			se.printStackTrace();
		}
		return connection;
	}

	public static void closeCon(){
		if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 根据结果集获取查询结果的别名
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	static String[] getColNames(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		//获取查询的列数
		int count = rsmd.getColumnCount();
		String[] colNames = new String[count];
		for(int i = 1; i <= count; i ++) {
			//获取查询类的别名
			colNames[i - 1] = rsmd.getColumnLabel(i);
		}
		return colNames;
	}


	public static List<Object> getObjects(ResultSet  rs,Class clazz) throws SQLException, IllegalAccessException, InstantiationException, InvocationTargetException {
		String[] colNames = getColNames(rs);
		List<Object> objects = new ArrayList<Object>();
		//获取所有的公共方法
		Method[] ms = clazz.getMethods();
		Object o ;
		String colName;
		String methodName;
		while(rs.next()){
			 o =clazz.newInstance();
			for (int i = 0; i <colNames.length ; i++) {
				 colName = colNames[i];
				//获取set方法的方法名
				 methodName = "set" + colName;
				for (Method m:ms) {
					if (methodName.equals(m.getName())){
						m.invoke(o,rs.getObject(colName));
						break;
					}
				}
				objects.add(o);
				colName =null;
			}
			o=null;
		}
		return objects;

	}
}
