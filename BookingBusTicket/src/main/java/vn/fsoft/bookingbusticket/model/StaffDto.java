package vn.fsoft.bookingbusticket.model;

public class StaffDto {
	private int staffId;
	private String address;
	private String email;
	private String fullName;
	private int phone;
	private double salary;
	private int accountId;
	private int roleId;

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
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

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
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

	public StaffDto(int staffId, String address, String email, String fullName, int phone, double salary, int accountId,
			int roleId) {
		super();
		this.staffId = staffId;
		this.address = address;
		this.email = email;
		this.fullName = fullName;
		this.phone = phone;
		this.salary = salary;
		this.accountId = accountId;
		this.roleId = roleId;
	}

	public StaffDto() {
		super();
	}

}
