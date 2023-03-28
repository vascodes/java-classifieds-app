package data;

import java.sql.*;

public class UserDAL {
	DB db = null;

	public UserDAL() {
		db = new DB();
	}
	
	public boolean addUser(String name, String phone, String email, String address, String username, String password) throws SQLIntegrityConstraintViolationException {
		boolean success = false;
		
		Connection con = db.getConnection();		
		PreparedStatement ps = null;		
				
		// TODO: Check if user already exists.
		
		// Insert into user table.
		String sql = "INSERT INTO tbl_user (name, phone, email, address, username, password) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setString(3, email);
			ps.setString(4, address);
			ps.setString(5, username);
			ps.setString(6, password);			
			ps.executeUpdate();			
			success = true;
		} 
		catch(SQLIntegrityConstraintViolationException icve) {
			throw new SQLIntegrityConstraintViolationException();
		}
		catch (SQLException e) {
			System.out.println("ERROR: Could not insert data to tbl_user.");
			e.printStackTrace();			
		}		

		return success;
	}

	public ResultSet getUserById(int id) {
		ResultSet rs = null;

		Connection con = db.getConnection();
		try {
			String sql = "SELECT * FROM tbl_user WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}
	
	public ResultSet getUserByUsername(String username) {
		ResultSet rs = null;

		Connection con = db.getConnection();
		try {
			String sql = "SELECT tu.* FROM tbl_user tu join tbl_login tl on tu.id = tl.user_id WHERE tl.username = ?";			
			PreparedStatement stmt = con.prepareStatement(sql);			
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}
}
