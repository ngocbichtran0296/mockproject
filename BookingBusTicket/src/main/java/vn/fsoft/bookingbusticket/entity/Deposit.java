package vn.fsoft.bookingbusticket.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the deposit database table.
 * 
 */
@Entity
@NamedQuery(name="Deposit.findAll", query="SELECT d FROM Deposit d")
public class Deposit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="deposit_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int depositId;

	private double amount;

	@Temporal(TemporalType.DATE)
	@Column(name="deposit_date")
	private Date depositDate;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="cust_id")
	private Customer customer;

	public Deposit() {
	}

	public int getDepositId() {
		return this.depositId;
	}

	public void setDepositId(int depositId) {
		this.depositId = depositId;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDepositDate() {
		return this.depositDate;
	}

	public void setDepositDate(Date depositDate) {
		this.depositDate = depositDate;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}