package vn.fsoft.bookingbusticket.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.fsoft.bookingbusticket.entity.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer>{
	Optional<Bus> findByBusName(String busName);
	
	@Query("SELECT b.busName FROM Bus b \r\n" + 
			"WHERE b.busId = :id")
	String findBusNameByBusId (@Param("id") int busId);
}
