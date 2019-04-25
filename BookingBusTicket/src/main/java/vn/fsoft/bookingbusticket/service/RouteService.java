package vn.fsoft.bookingbusticket.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import vn.fsoft.bookingbusticket.entity.Route;
import vn.fsoft.bookingbusticket.model.RouteDto;

public interface RouteService {
	CrudRepository<Route, Integer> getRepo();
	
	List<Route> retrieveRouteByFromAndToPlaceId(int fromPlaceId,int toPlaceId);
	
	List<RouteDto> getRouteByPlaceId(int placeId1, int placeId2);
	
	List<RouteDto> getRouteByStartDate (List<RouteDto> routeDto,Date startdate);
}
