package vn.fsoft.bookingbusticket.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the bus database table.
 * 
 */
@Entity
@NamedQuery(name="Bus.findAll", query="SELECT b FROM Bus b")
public class Bus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="bus_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int busId;

	@Column(name="bus_name")
	private String busName;

	//bi-directional many-to-one association to Seat
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="seats_id")
	private Seat seat;

	public Bus() {
	}

	public int getBusId() {
		return this.busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getBusName() {
		return this.busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public Seat getSeat() {
		return this.seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

}