package vn.fsoft.bookingbusticket.entity;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the routes database table.
 * 
 */
@Entity
@Table(name="routes")
@NamedQuery(name="Route.findAll", query="SELECT r FROM Route r")
public class Route implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="routes_id")
	private int routesId;

	@Column(name="bus_id")
	private int busId;

	private double distance;

	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	private double price;

	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;

	//bi-directional many-to-one association to Place
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="from_place_id")
	private Place place1;

	//bi-directional many-to-one association to Place
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="to_place_id")
	private Place place2;

	//bi-directional many-to-one association to SeatJunction
	@OneToMany(mappedBy="route")
	@JsonIgnore
	private List<SeatJunction> seatJunctions;

	//bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy="route")
	@JsonIgnore
	private List<Ticket> tickets;
	
	private Time departture;

	public Route() {
	}

	public int getRoutesId() {
		return this.routesId;
	}

	public void setRoutesId(int routesId) {
		this.routesId = routesId;
	}

	public int getBusId() {
		return this.busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public double getDistance() {
		return this.distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Place getPlace1() {
		return this.place1;
	}

	public void setPlace1(Place place1) {
		this.place1 = place1;
	}

	public Place getPlace2() {
		return this.place2;
	}

	public void setPlace2(Place place2) {
		this.place2 = place2;
	}

	public List<SeatJunction> getSeatJunctions() {
		return this.seatJunctions;
	}

	public void setSeatJunctions(List<SeatJunction> seatJunctions) {
		this.seatJunctions = seatJunctions;
	}

	public SeatJunction addSeatJunction(SeatJunction seatJunction) {
		getSeatJunctions().add(seatJunction);
		seatJunction.setRoute(this);

		return seatJunction;
	}

	public SeatJunction removeSeatJunction(SeatJunction seatJunction) {
		getSeatJunctions().remove(seatJunction);
		seatJunction.setRoute(null);

		return seatJunction;
	}

	public List<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Ticket addTicket(Ticket ticket) {
		getTickets().add(ticket);
		ticket.setRoute(this);

		return ticket;
	}

	public Ticket removeTicket(Ticket ticket) {
		getTickets().remove(ticket);
		ticket.setRoute(null);

		return ticket;
	}

	public Time getDepartture() {
		return departture;
	}

	public void setDepartture(Time departture) {
		this.departture = departture;
	}
	
	
}