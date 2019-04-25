package vn.fsoft.bookingbusticket.model;

public class ChairDto {
	private int chairId;
	private String chairName;
	private int status;
	private int busId;
	private int routeId;
	
	public int getChairId() {
		return chairId;
	}
	public void setChairId(int chairId) {
		this.chairId = chairId;
	}
	public String getChairName() {
		return chairName;
	}
	public void setChairName(String chairName) {
		this.chairName = chairName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public ChairDto(int chairId, String chairName, int status, int busId, int routeId) {
		super();
		this.chairId = chairId;
		this.chairName = chairName;
		this.status = status;
		this.busId = busId;
		this.routeId = routeId;
	}
	public ChairDto() {
		super();
	}
}
