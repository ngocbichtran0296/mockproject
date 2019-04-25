package vn.fsoft.bookingbusticket.model;

public class AccountUserDto {

	private int accountId;

	private String userName;

	private String userPassword;

	private int role;

	public AccountUserDto() {
		super();
	}

	public AccountUserDto(int accountId, String userName, String userPassword, int role) {
		super();
		this.accountId = accountId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.role = role;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getRole() {
		return role;
	}

	public void setRoleList(int role) {
		this.role = role;
	}

}
