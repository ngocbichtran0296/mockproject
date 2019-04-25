package vn.fsoft.bookingbusticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.fsoft.bookingbusticket.entity.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer>{
	
}
