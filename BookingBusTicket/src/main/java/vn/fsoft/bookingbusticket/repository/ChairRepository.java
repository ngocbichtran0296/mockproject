package vn.fsoft.bookingbusticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.fsoft.bookingbusticket.entity.Chair;

@Repository
public interface ChairRepository extends JpaRepository<Chair, Integer>{
	@Query("SELECT c.chairName FROM Chair c \n" + 
			"WHERE c.chairId = :chairId")
	String getChairNameByChairId(@Param("chairId")int chairId);
	
	
}
