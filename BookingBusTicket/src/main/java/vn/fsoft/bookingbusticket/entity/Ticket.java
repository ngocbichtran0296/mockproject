package vn.fsoft.bookingbusticket.entity;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ticket database table.
 * 
 */
@Entity
@NamedQuery(name="Ticket.findAll", query="SELECT t FROM Ticket t")
public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ticket_id")
	private int ticketId;

	@Temporal(TemporalType.DATE)
	@Column(name="booking_date")
	private Date bookingDate;

	@Column(name="ticket_status")
	private int ticketStatus;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="ticket")
	private List<Payment> payments;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="cust_id")
	private Customer customer;

	//bi-directional many-to-one association to Noneuser
	@ManyToOne
	@JoinColumn(name="noneUserId")
	private Noneuser noneuser;

	//bi-directional many-to-one association to Route
	@ManyToOne
	@JoinColumn(name="routes_id")
	private Route route;

	//bi-directional many-to-one association to SeatJunction
	@ManyToOne
	@JoinColumn(name="chair_id")
	private SeatJunction seatJunction;
	
	private Time bookingTime;

	public Ticket() {
	}

	public int getTicketId() {
		return this.ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public Date getBookingDate() {
		return this.bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getTicketStatus() {
		return this.ticketStatus;
	}

	public void setTicketStatus(int ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setTicket(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setTicket(null);

		return payment;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Noneuser getNoneuser() {
		return this.noneuser;
	}

	public void setNoneuser(Noneuser noneuser) {
		this.noneuser = noneuser;
	}

	public Route getRoute() {
		return this.route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public SeatJunction getSeatJunction() {
		return this.seatJunction;
	}

	public void setSeatJunction(SeatJunction seatJunction) {
		this.seatJunction = seatJunction;
	}

	public Time getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(Time bookingTime) {
		this.bookingTime = bookingTime;
	}
	
}