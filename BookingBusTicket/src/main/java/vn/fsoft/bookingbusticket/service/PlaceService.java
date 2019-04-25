package vn.fsoft.bookingbusticket.service;

import org.springframework.data.repository.CrudRepository;

import vn.fsoft.bookingbusticket.entity.Place;

public interface PlaceService {

	CrudRepository<Place, Integer> getRepo();
	
	String getPlaceNameById(int id);
	
	int getPlaceIdByPlaceName(String placeName);
}
