package vn.fsoft.bookingbusticket.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import vn.fsoft.bookingbusticket.entity.SeatJunction;
import vn.fsoft.bookingbusticket.model.ChairDto;

public interface SeatJunctionService {
	CrudRepository<SeatJunction, Integer> getRepo();
	
	List<SeatJunction> getSeatJunctionByRouteId(int routeId);
	
	List<ChairDto> getChairByRouteId(int routeId);
}
