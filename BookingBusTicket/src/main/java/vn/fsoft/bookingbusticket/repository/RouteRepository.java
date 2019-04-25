package vn.fsoft.bookingbusticket.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.fsoft.bookingbusticket.entity.Place;
import vn.fsoft.bookingbusticket.entity.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer>{
	List<Route> findByPlace1AndPlace2(Place startPlace, Place endPlace);
	
	// find route by from_place_id and to_place_id
	@Query("SELECT r FROM Route r \r\n"+
			"WHERE r.place1.placeId = :startPlaceId\r\n"+
			"AND r.place2.placeId = :endPlaceId")
	List<Route> findByStartPlaceIdAndEndPlaceId(
			@Param("startPlaceId") int startPlaceId,
			@Param("endPlaceId") int endPlaceId);
	
	List<Route> findByStartDate(Date startDate);
}
