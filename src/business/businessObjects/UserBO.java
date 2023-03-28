package business.businessObjects;

public class UserBO {
	private int id;
	private String name;
	private String phone;
	private String email;
	private String address;
	private String username;
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public UserBO(String name, String phone, String email, String address, String username, String password) {
		this.setName(name);
		this.setPhone(phone);
		this.setEmail(email);
		this.setAddress(address);
		this.setUsername(username);
		this.setPassword(password);
	}

	@Override
	public String toString() {
		return String.format("Id: %d, Name: %s, Phone: %s, Email: %s, Address: %s, username: %s", id, name, phone, email, address, username);
	}
}
