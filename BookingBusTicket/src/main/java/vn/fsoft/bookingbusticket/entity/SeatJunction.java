package vn.fsoft.bookingbusticket.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the seat_junction database table.
 * 
 */
@Entity
@Table(name="seat_junction")
@NamedQuery(name="SeatJunction.findAll", query="SELECT s FROM SeatJunction s")
public class SeatJunction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="seats_junc_id")
	private int seatsJuncId;

	@Column(name="chair_status")
	private int chairStatus;

	//bi-directional many-to-one association to Chair
	@ManyToOne
	@JoinColumn(name="chair_id")
	private Chair chair;

	//bi-directional many-to-one association to Route
	@ManyToOne
	@JoinColumn(name="routes_id")
	private Route route;

	//bi-directional many-to-one association to Seat
	@ManyToOne
	@JoinColumn(name="seats_id")
	private Seat seat;

	//bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy="seatJunction")
	private List<Ticket> tickets;

	public SeatJunction() {
	}

	public int getSeatsJuncId() {
		return this.seatsJuncId;
	}

	public void setSeatsJuncId(int seatsJuncId) {
		this.seatsJuncId = seatsJuncId;
	}

	public int getChairStatus() {
		return this.chairStatus;
	}

	public void setChairStatus(int chairStatus) {
		this.chairStatus = chairStatus;
	}

	public Chair getChair() {
		return this.chair;
	}

	public void setChair(Chair chair) {
		this.chair = chair;
	}

	public Route getRoute() {
		return this.route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Seat getSeat() {
		return this.seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public List<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Ticket addTicket(Ticket ticket) {
		getTickets().add(ticket);
		ticket.setSeatJunction(this);

		return ticket;
	}

	public Ticket removeTicket(Ticket ticket) {
		getTickets().remove(ticket);
		ticket.setSeatJunction(null);

		return ticket;
	}

}