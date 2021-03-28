package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionToDb {
	private static String USERNAME="root";
	private static String PWD="root";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String URL="jdbc:mysql://localhost:3306/umar";
	//public static void main(String[] args) {
		//System.out.println(get_Connection());
//}
	public static Connection get_Connection() {
      
		Connection conn=null;
		try {
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL,USERNAME,PWD);

		} catch (Exception e) {
        e.printStackTrace();
		}
		return conn;
		
	}

}
