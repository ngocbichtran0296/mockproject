package vn.fsoft.bookingbusticket.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the chair database table.
 * 
 */
@Entity
@NamedQuery(name="Chair.findAll", query="SELECT c FROM Chair c")
public class Chair implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="chair_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int chairId;

	@Column(name="chair_name")
	private String chairName;

	//bi-directional many-to-one association to SeatJunction
	@OneToMany(mappedBy="chair")
	private List<SeatJunction> seatJunctions;

	public Chair() {
	}

	public int getChairId() {
		return this.chairId;
	}

	public void setChairId(int chairId) {
		this.chairId = chairId;
	}

	public String getChairName() {
		return this.chairName;
	}

	public void setChairName(String chairName) {
		this.chairName = chairName;
	}

	public List<SeatJunction> getSeatJunctions() {
		return this.seatJunctions;
	}

	public void setSeatJunctions(List<SeatJunction> seatJunctions) {
		this.seatJunctions = seatJunctions;
	}

	public SeatJunction addSeatJunction(SeatJunction seatJunction) {
		getSeatJunctions().add(seatJunction);
		seatJunction.setChair(this);

		return seatJunction;
	}

	public SeatJunction removeSeatJunction(SeatJunction seatJunction) {
		getSeatJunctions().remove(seatJunction);
		seatJunction.setChair(null);

		return seatJunction;
	}

}