package vn.fsoft.bookingbusticket.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the account_user database table.
 * 
 */
@Entity
@Table(name="account_user")
@NamedQuery(name="AccountUser.findAll", query="SELECT a FROM AccountUser a")
public class AccountUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="account_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;

	@Column(name="user_name")
	private String userName;

	@Column(name="user_password")
	private String userPassword;

	//bi-directional many-to-one association to Role
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="accountUser")
	@JsonIgnore
	private List<Customer> customers;

	//bi-directional many-to-one association to Staff
	@OneToMany(mappedBy="accountUser")
	@JsonIgnore
	private List<Staff> staffs;

	public AccountUser() {
	}
	

	public AccountUser(String userName, String userPassword, Role role) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.role = role;
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setAccountUser(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setAccountUser(null);

		return customer;
	}

	public List<Staff> getStaffs() {
		return this.staffs;
	}

	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

	public Staff addStaff(Staff staff) {
		getStaffs().add(staff);
		staff.setAccountUser(this);

		return staff;
	}

	public Staff removeStaff(Staff staff) {
		getStaffs().remove(staff);
		staff.setAccountUser(null);

		return staff;
	}

}