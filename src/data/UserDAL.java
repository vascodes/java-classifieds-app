package data;

import java.sql.*;

import javax.swing.JOptionPane;

public class UserDAL {
	DB db = null;

	public UserDAL() {
		db = new DB();
	}

	public ResultSet getUserById(int id) {
		ResultSet rs = null;

		Connection con = db.getConnection();
		try {
			String sql = "SELECT * FROM tbl_user WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	public boolean addUser(String name, String phone, String email, String address, String username, String password) {
		Connection con = db.getConnection();
		String sql;
		PreparedStatement ps = null;
		int lastInsertedUserId = 0;
		boolean isAdded = false;

		// Insert into user table.
		sql = "INSERT INTO tbl_user (name, phone, email, address) VALUES (?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setString(3, email);
			ps.setString(4, address);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("ERROR: Could not insert data to tbl_user.");
			e.printStackTrace();			
		}

		// Get last inserted user id.
		sql = "SELECT TBL_USER_ID_SEQ.CURRVAL FROM DUAL";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				lastInsertedUserId = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("ERROR: Could not fetch last inserted id from tbl_user.");
			e.printStackTrace();
		}

		// Insert into login table.
		sql = "INSERT INTO tbl_login (user_id, username, password) VALUES (?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, lastInsertedUserId);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.executeUpdate();
			isAdded = true;
		} catch (SQLException e) {
			System.out.println("ERROR: Could not insert data to tbl_login.");
			e.printStackTrace();
		}

		return isAdded;
	}
}
