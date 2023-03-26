package business.businessObjects;

public class LoginBO {
	private int id;
	private int userId;
	private String username;
	private String password;

	public int getId() {
		return id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public LoginBO(String username, String password) {
		setUsername(username);
		setPassword(password);
	}
}
