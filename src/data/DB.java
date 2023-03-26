package data;

import java.io.*;
import java.sql.*;

public class DB {
	private Connection con = null;
	private String CONNECTION_STRING;
	private String DB_USER;
	private String DB_PASS;

	public DB() {
		try {
			ConfigManager cm = new ConfigManager();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			CONNECTION_STRING = cm.getDBConnectionString();
			DB_USER = cm.getDBUser();
			DB_PASS = cm.getDBPass();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		if (con == null) {
			try {
				con = DriverManager.getConnection(CONNECTION_STRING, DB_USER, DB_PASS);
			} catch (SQLException e) {
				e.printStackTrace();				
			}
		}

		return con;
	}

	public void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
	}
}