package vn.fsoft.bookingbusticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.fsoft.bookingbusticket.entity.SeatJunction;

@Repository
public interface SeatJunctionRepository extends JpaRepository<SeatJunction, Integer> {
	@Query("SELECT s FROM SeatJunction s \n" + "WHERE s.route.routesId = :routeId")
	List<SeatJunction> findSeatJunctionByRouteId(@Param("routeId")int routeId);
	
	
}
