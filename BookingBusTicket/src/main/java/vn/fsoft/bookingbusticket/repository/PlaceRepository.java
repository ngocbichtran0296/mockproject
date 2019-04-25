package vn.fsoft.bookingbusticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.fsoft.bookingbusticket.entity.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {
	@Query("SELECT p.placeName FROM Place p \r\n" + 
			"WHERE p.placeId = :id")
	String findPlaceNameByPlaceId(@Param("id")int placeId);
	
	@Query("SELECT p.placeId FROM Place p \r\n" + 
	"WHERE p.placeName = :placeName")
	int findPlaceIdByPlaceName(@Param("placeName") String placeName);
}
