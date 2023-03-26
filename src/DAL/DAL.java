package DAL;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DAL {
	private String CONNECTION_STRING;
	private String DB_USER;
	private String DB_PASS;

	public DAL() {
		try {
			String confgFilePath = "src/app.config";
			FileInputStream fis = new FileInputStream(confgFilePath);
			Properties prop = new Properties();
			prop.load(fis);

			CONNECTION_STRING = prop.getProperty("DB_CON");
			DB_USER = prop.getProperty("DB_USER");
			DB_PASS = prop.getProperty("DB_PASS");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(CONNECTION_STRING, DB_USER, DB_PASS);

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
			ResultSet rs = stmt.executeQuery("SELECT CURRENT_DATE FROM DUAL");

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
