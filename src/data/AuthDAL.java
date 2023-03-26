package data;

import java.sql.*;

import business.businessObjects.LoginBO;

public class AuthDAL {
	DB db = null;

	public AuthDAL(){
		
	}
	
	public boolean checkLogin(LoginBO loginBO) {				
		try {
			ResultSet rs = null;
			Connection con = db.getConnection();

			String sql = "SELECT * FROM tbl_login WHERE username = ? AND password = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, loginBO.getUsername());
			stmt.setString(2, loginBO.getPassword());
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}
