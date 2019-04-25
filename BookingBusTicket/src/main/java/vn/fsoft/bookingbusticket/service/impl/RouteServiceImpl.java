package vn.fsoft.bookingbusticket.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import vn.fsoft.bookingbusticket.entity.Route;
import vn.fsoft.bookingbusticket.exception.NotFoundException;
import vn.fsoft.bookingbusticket.model.RouteDto;
import vn.fsoft.bookingbusticket.repository.BusRepository;
import vn.fsoft.bookingbusticket.repository.PlaceRepository;
import vn.fsoft.bookingbusticket.repository.RouteRepository;
import vn.fsoft.bookingbusticket.service.RouteService;

@Service
public class RouteServiceImpl implements RouteService{
	@Autowired
	private RouteRepository routeRepository;
	
	@Autowired
	PlaceRepository placeRepository;
	
	@Autowired
	BusRepository busRepository;
	
	@Override
	public CrudRepository<Route, Integer> getRepo() {
		// TODO Auto-generated method stub
		return routeRepository;
	}

	@Override
	public List<Route> retrieveRouteByFromAndToPlaceId(int fromPlaceId, int toPlaceId) {
		List<Route> routes =routeRepository.findByStartPlaceIdAndEndPlaceId(fromPlaceId, toPlaceId);
		if(routes.isEmpty()) {
			throw new NotFoundException("Route not found!");
		}
		return routes;
	}

	@Override
	public List<RouteDto> getRouteByPlaceId(int placeId1, int placeId2) {
		List<RouteDto> routeDtoList =new ArrayList<>();
		RouteDto rDto;
		List<Route> routes = routeRepository.findByStartPlaceIdAndEndPlaceId(placeId1, placeId2);
		if(routes.isEmpty()) {
			throw new NotFoundException("Rout not found!");
		}
		for(Route r : routes) {
			//System.out.println("bus id = "+r.getBusId());
			rDto =new RouteDto();
			rDto.setBusId(r.getBusId());
			rDto.setRouteId(r.getRoutesId());
			rDto.setDistance(r.getDistance());
			rDto.setFromPlace(placeRepository.findPlaceNameByPlaceId(placeId1));
			rDto.setToPlace(placeRepository.findPlaceNameByPlaceId(placeId2));
			rDto.setStartDate(r.getStartDate());
			rDto.setEndDate(r.getEndDate());
			rDto.setBusName(busRepository.findBusNameByBusId(r.getBusId()));
			rDto.setPrice(r.getPrice());
			rDto.setDeparture(r.getDepartture());
			routeDtoList.add(rDto);
		}
		return routeDtoList;
	}

	@Override
	public List<RouteDto> getRouteByStartDate(List<RouteDto> routeDto, Date startdate) {
		List<RouteDto> listRoute = new ArrayList<>();
		RouteDto route;
		for(RouteDto r :routeDto) {
			//System.out.println("date = "+r.getStartDate().compareTo(startdate));
			if(r.getStartDate().compareTo(startdate)==0) {
				route=new RouteDto();
				route.setDeparture(r.getDeparture());
				route.setBusId(r.getBusId());
				route.setBusName(busRepository.findBusNameByBusId(r.getBusId()));
				route.setDistance(r.getDistance());
				route.setFromPlace(r.getFromPlace());
				route.setToPlace(r.getToPlace());
				route.setPrice(r.getPrice());
				route.setStartDate(r.getStartDate());
				route.setEndDate(r.getEndDate());
				route.setRouteId(r.getRouteId());
				
				listRoute.add(route);
			}
		}
		return listRoute;
	}

	
	
}
