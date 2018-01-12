package com.cognizant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFile {

	private Connection connection = null;
	private final static String user = "root";
	private final static String password = "";

	public static Connection getConexion() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/robotech" , user, password);
		return connection;
	}

	public static void closeConnection() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		getConexion().close();
	}

}
