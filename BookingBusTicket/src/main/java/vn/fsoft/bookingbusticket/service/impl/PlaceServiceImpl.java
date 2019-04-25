package vn.fsoft.bookingbusticket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import vn.fsoft.bookingbusticket.entity.Place;
import vn.fsoft.bookingbusticket.exception.NotFoundException;
import vn.fsoft.bookingbusticket.repository.PlaceRepository;
import vn.fsoft.bookingbusticket.service.PlaceService;

@Service
public class PlaceServiceImpl implements PlaceService{
	@Autowired
	PlaceRepository placeRepository;
	
	@Override
	public CrudRepository<Place, Integer> getRepo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPlaceNameById(int id) {
		String placeName = placeRepository.findPlaceNameByPlaceId(id);
		if(placeName.equals("")) {
			throw new NotFoundException("Place name not found!");
		}
		return placeName;
	}

	@Override
	public int getPlaceIdByPlaceName(String placeName) {
		int placeId = placeRepository.findPlaceIdByPlaceName(placeName);
		
		return placeId;
	}

}
