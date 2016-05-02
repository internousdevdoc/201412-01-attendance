package jp.co.internous.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBconnector{

	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/kintai2";
	private static String user = "root";
	private static String pass = "mysql";

	public static Connection getConnection() throws ClassNotFoundException{

		System.out.println("DBconnector - SQL接続start");

		Connection con= null;

		try{
			Class.forName(driverName);
			con=DriverManager.getConnection(url,user,pass);
		}//try

		catch(ClassNotFoundException e){
		 System.out.println(e);
		}
		catch(SQLException e){
			System.out.println(e);
		}
		System.out.println("DBconnector - OK");
		return con;

	}//connection
}//class