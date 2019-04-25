package vn.fsoft.bookingbusticket.model;

public class CustomerDto {
	private int custId;
	private String address;
	private String email;
	private String fullName;
	private String phone;
	private double balance;
	private int accountId;
	private int roleId;

	public int getStaffId() {
		return custId;
	}

	public void setStaffId(int staffId) {
		this.custId = staffId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public CustomerDto(int staffId, String address, String email, String fullName, String phone, double balance,
			int accountId, int roleId) {
		super();
		this.custId = staffId;
		this.address = address;
		this.email = email;
		this.fullName = fullName;
		this.phone = phone;
		this.balance = balance;
		this.accountId = accountId;
		this.roleId = roleId;
	}

	public CustomerDto() {
		super();
	}

}
