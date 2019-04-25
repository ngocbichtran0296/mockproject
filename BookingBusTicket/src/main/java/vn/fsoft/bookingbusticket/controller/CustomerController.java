package vn.fsoft.bookingbusticket.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.fsoft.bookingbusticket.entity.Bus;
import vn.fsoft.bookingbusticket.model.ChairDto;
import vn.fsoft.bookingbusticket.model.RouteDto;
import vn.fsoft.bookingbusticket.service.BusService;
import vn.fsoft.bookingbusticket.service.PlaceService;
import vn.fsoft.bookingbusticket.service.RouteService;
import vn.fsoft.bookingbusticket.service.SeatJunctionService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

	@Autowired
	BusService busService;

	@Autowired
	RouteService routeService;

	@Autowired
	PlaceService placeService;

	@Autowired
	SeatJunctionService seatJunctionService;

	@GetMapping("/listBus")
	public List<Bus> getAllBus() {
		List<Bus> busList = busService.retrieveAllBus();
		return busList;
	}

	// find route by placeName and start_date
	@GetMapping("/route_by_place_and_date")
	public List<RouteDto> getRoute(@RequestParam String fromPlace, @RequestParam String toPlace,
			@RequestParam String date) {
		int placeId1 = placeService.getPlaceIdByPlaceName(fromPlace);
		int placeId2 = placeService.getPlaceIdByPlaceName(toPlace);
		List<RouteDto> routeDtoList = routeService.getRouteByPlaceId(placeId1, placeId2);
		// System.out.println("list route dto: "+ routeDtoList.toString());
		List<RouteDto> routeList = null;
		DateFormat formatter;
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date1 = null;
			date1 = (Date) formatter.parse(date);
			routeList = routeService.getRouteByStartDate(routeDtoList, date1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return routeList;
	}

	@GetMapping("/route_by_place")
	public List<RouteDto> getRouteByPlace(@RequestParam String fromPlace, @RequestParam String toPlace) {
		int placeId1 = placeService.getPlaceIdByPlaceName(fromPlace);
		int placeId2 = placeService.getPlaceIdByPlaceName(toPlace);
		List<RouteDto> routeDtoList = routeService.getRouteByPlaceId(placeId1, placeId2);

		return routeDtoList;
	}

	//get chair by route_id
	@GetMapping("/chair")
	public List<ChairDto> getChairByRouteId(@RequestParam int routeId) {
		return seatJunctionService.getChairByRouteId(routeId);
	}
	
	
}
