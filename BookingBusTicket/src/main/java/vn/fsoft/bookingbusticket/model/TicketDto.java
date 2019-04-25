package vn.fsoft.bookingbusticket.model;

import java.sql.Time;
import java.util.Date;

public class TicketDto {
	private int ticketId;
	private int custId;
	private int noneUserId;
	private String noneUserName;
	private String custName;
	private Date bookingDate;
	private Time bookingTime;
	private int ticketStatus;
	private int routeId;
	private String fromPlace;
	private String toPlace;
	private int chairId;
	private String chairName;
	private int busId;
	private String busName;
	private Date startDate;
	private Time departure;
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getNoneUserId() {
		return noneUserId;
	}
	public void setNoneUserId(int noneUserId) {
		this.noneUserId = noneUserId;
	}
	public String getNoneUserName() {
		return noneUserName;
	}
	public void setNoneUserName(String noneUserName) {
		this.noneUserName = noneUserName;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Time getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(Time bookingTime) {
		this.bookingTime = bookingTime;
	}
	public int getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(int ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Time getDeparture() {
		return departure;
	}
	public void setDeparture(Time departure) {
		this.departure = departure;
	}
	public TicketDto(int ticketId, int custId, int noneUserId, String noneUserName, String custName, Date bookingDate,
			Time bookingTime, int ticketStatus, int routeId, String fromPlace, String toPlace, int chairId,
			String chairName, int busId, String busName, Date startDate, Time departure) {
		super();
		this.ticketId = ticketId;
		this.custId = custId;
		this.noneUserId = noneUserId;
		this.noneUserName = noneUserName;
		this.custName = custName;
		this.bookingDate = bookingDate;
		this.bookingTime = bookingTime;
		this.ticketStatus = ticketStatus;
		this.routeId = routeId;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.chairId = chairId;
		this.chairName = chairName;
		this.busId = busId;
		this.busName = busName;
		this.startDate = startDate;
		this.departure = departure;
	}
	public TicketDto() {
		super();
	}
}
