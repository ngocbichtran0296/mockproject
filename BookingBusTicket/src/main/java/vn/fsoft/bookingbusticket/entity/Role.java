package vn.fsoft.bookingbusticket.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="role_id")
	private int roleId;

	@Column(name="role_name")
	private String roleName;

	//bi-directional many-to-one association to AccountUser
	@OneToMany(mappedBy="role")
	private List<AccountUser> accountUsers;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="role")
	private List<Customer> customers;

	//bi-directional many-to-one association to Staff
	@OneToMany(mappedBy="role")
	private List<Staff> staffs;

	public Role() {
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<AccountUser> getAccountUsers() {
		return this.accountUsers;
	}

	public void setAccountUsers(List<AccountUser> accountUsers) {
		this.accountUsers = accountUsers;
	}

	public AccountUser addAccountUser(AccountUser accountUser) {
		getAccountUsers().add(accountUser);
		accountUser.setRole(this);

		return accountUser;
	}

	public AccountUser removeAccountUser(AccountUser accountUser) {
		getAccountUsers().remove(accountUser);
		accountUser.setRole(null);

		return accountUser;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setRole(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setRole(null);

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
		staff.setRole(this);

		return staff;
	}

	public Staff removeStaff(Staff staff) {
		getStaffs().remove(staff);
		staff.setRole(null);

		return staff;
	}

	public Role(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}
	
}