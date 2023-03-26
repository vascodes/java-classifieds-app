package DAL;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

public class DAL {
	private Connection con = null;
	private String CONNECTION_STRING;
	private String DB_USER;
	private String DB_PASS;

	public DAL() {
		try {
			ConfigManager cm = new ConfigManager();

			CONNECTION_STRING = cm.getDBConnectionString();
			DB_USER = cm.getDBUser();
			DB_PASS = cm.getDBPass();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		if (con == null || con.isClosed())
			con = DriverManager.getConnection(CONNECTION_STRING, DB_USER, DB_PASS);

		return con;
	}
}

class Demo {
	public static void main(String[] args) {
		DAL dal = new DAL();
		Connection con;
		try {
			con = dal.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT 'Hello World!' FROM DUAL");

			if (rs.next()) {
				System.out.println(rs.getString(1));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
