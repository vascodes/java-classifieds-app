package business.businessObjects;

public class UserBO {
	private int id;
	private String name;
	private String phone;
	private String email;
	private String address;

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

	public void mapUserWithId(int id, String name, String phone, String email, String address) {
		this.setId(id);
		this.setName(name);
		this.setPhone(phone);
		this.setEmail(email);
		this.setAddress(address);
	}

	public void mapUserWithoutId(String name, String phone, String email, String address) {
		this.setName(name);
		this.setPhone(phone);
		this.setEmail(email);
		this.setAddress(address);
	}

	public UserBO() {
	};

	public UserBO(String name, String phone, String email, String address) {
		mapUserWithoutId(name, phone, email, address);
	}

	public UserBO(int id, String name, String phone, String email, String address) {
		mapUserWithId(id, name, phone, email, address);
	}

	@Override
	public String toString() {
		return String.format("Id: %d, Name: %s, Phone: %s, Email: %s, Address: %s", id, name, phone, email, address);
	}
}
