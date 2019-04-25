package vn.fsoft.bookingbusticket.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import vn.fsoft.bookingbusticket.entity.Chair;

public interface ChairService {
	
	CrudRepository<Chair,Integer> getRepo();
	
	List<Chair> retrieveAllChair();
	
	Chair retrieveChairById(int id);
	
	Chair retrieveChairByName (String name);
	
	//[10] Chair addChair(Chair chair);
	
	List<Chair> retrieveChairByRouteId(int routeId);
}
