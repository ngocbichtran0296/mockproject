package vn.fsoft.bookingbusticket.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the seats database table.
 * 
 */
@Entity
@Table(name="seats")
@NamedQuery(name="Seat.findAll", query="SELECT s FROM Seat s")
public class Seat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="seats_id")
	private int seatsId;

	@Column(name="total_seat")
	private int totalSeat;

	//bi-directional many-to-one association to Bus
	@OneToMany(mappedBy="seat")
	private List<Bus> buses;

	//bi-directional many-to-one association to SeatJunction
	@OneToMany(mappedBy="seat")
	private List<SeatJunction> seatJunctions;

	public Seat() {
	}

	public int getSeatsId() {
		return this.seatsId;
	}

	public void setSeatsId(int seatsId) {
		this.seatsId = seatsId;
	}

	public int getTotalSeat() {
		return this.totalSeat;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}

	public List<Bus> getBuses() {
		return this.buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	public Bus addBus(Bus bus) {
		getBuses().add(bus);
		bus.setSeat(this);

		return bus;
	}

	public Bus removeBus(Bus bus) {
		getBuses().remove(bus);
		bus.setSeat(null);

		return bus;
	}

	public List<SeatJunction> getSeatJunctions() {
		return this.seatJunctions;
	}

	public void setSeatJunctions(List<SeatJunction> seatJunctions) {
		this.seatJunctions = seatJunctions;
	}

	public SeatJunction addSeatJunction(SeatJunction seatJunction) {
		getSeatJunctions().add(seatJunction);
		seatJunction.setSeat(this);

		return seatJunction;
	}

	public SeatJunction removeSeatJunction(SeatJunction seatJunction) {
		getSeatJunctions().remove(seatJunction);
		seatJunction.setSeat(null);

		return seatJunction;
	}

}