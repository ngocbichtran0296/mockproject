package vn.fsoft.bookingbusticket.model;

import java.sql.Time;
import java.util.Date;

public class RouteDto {
	private int routeId;
	private int busId;
	private String busName;
	private double distance;
	private Date startDate;
	private Date endDate;
	private double price;
	private String fromPlace;
	private String toPlace;
	private Time departure;
	
	public RouteDto(int routeId, int busId, String busName, double distance, Date startDate, Date endDate, double price,
			String fromPlace, String toPlace, Time departure) {
		super();
		this.routeId = routeId;
		this.busId = busId;
		this.busName = busName;
		this.distance = distance;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.departure = departure;
	}
	public Time getDeparture() {
		return departure;
	}
	public void setDeparture(Time departure) {
		this.departure = departure;
	}
	public RouteDto() {
		super();
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getFromPlace() {
		return fromPlace;
	}
	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}
	public String getToPlace() {
		return toPlace;
	}
	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}
	@Override
	public String toString() {
		return "RouteDto [routeId=" + routeId + ", busId=" + busId + ", busName=" + busName + ", distance=" + distance
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", price=" + price + ", fromPlace=" + fromPlace
				+ ", toPlace=" + toPlace + ", departure=" + departure + "]";
	}
	
}
