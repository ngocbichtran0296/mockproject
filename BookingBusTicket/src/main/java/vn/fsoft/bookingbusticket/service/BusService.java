package vn.fsoft.bookingbusticket.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import vn.fsoft.bookingbusticket.entity.Bus;

public interface BusService {
	CrudRepository<Bus, Integer> getRepo();
	
	Bus retrieveBusById(int id);
	
	List<Bus> retrieveAllBus();
	
	Bus addBus(Bus bus);
	
	Bus retrieveBusByName(String busName);
	
	String getBusNameById (int busId);
}
