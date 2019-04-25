package vn.fsoft.bookingbusticket.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cust_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int custId;

	private String address;

	private double balance;

	private String email;

	@Column(name="full_name")
	private String fullName;

	private String phone;

	//bi-directional many-to-one association to AccountUser
	@ManyToOne
	@JoinColumn(name="account_id")
	private AccountUser accountUser;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;

	//bi-directional many-to-one association to Deposit
	@OneToMany(mappedBy="customer")
	private List<Deposit> deposits;

	//bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy="customer")
	private List<Ticket> tickets;

	public Customer() {
	}

	public int getCustId() {
		return this.custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public AccountUser getAccountUser() {
		return this.accountUser;
	}

	public void setAccountUser(AccountUser accountUser) {
		this.accountUser = accountUser;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Deposit> getDeposits() {
		return this.deposits;
	}

	public void setDeposits(List<Deposit> deposits) {
		this.deposits = deposits;
	}

	public Deposit addDeposit(Deposit deposit) {
		getDeposits().add(deposit);
		deposit.setCustomer(this);

		return deposit;
	}

	public Deposit removeDeposit(Deposit deposit) {
		getDeposits().remove(deposit);
		deposit.setCustomer(null);

		return deposit;
	}

	public List<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Ticket addTicket(Ticket ticket) {
		getTickets().add(ticket);
		ticket.setCustomer(this);

		return ticket;
	}

	public Ticket removeTicket(Ticket ticket) {
		getTickets().remove(ticket);
		ticket.setCustomer(null);

		return ticket;
	}

	public Customer(String address, double balance, String email, String fullName, String phone,
			AccountUser accountUser, Role role, List<Deposit> deposits, List<Ticket> tickets) {
		super();
		this.address = address;
		this.balance = balance;
		this.email = email;
		this.fullName = fullName;
		this.phone = phone;
		this.accountUser = accountUser;
		this.role = role;
		this.deposits = deposits;
		this.tickets = tickets;
	}

	
}