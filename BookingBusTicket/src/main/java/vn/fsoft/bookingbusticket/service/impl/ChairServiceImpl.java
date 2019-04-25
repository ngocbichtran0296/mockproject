package vn.fsoft.bookingbusticket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import vn.fsoft.bookingbusticket.entity.Chair;
import vn.fsoft.bookingbusticket.repository.ChairRepository;
import vn.fsoft.bookingbusticket.service.ChairService;

@Service
public class ChairServiceImpl implements ChairService{
	@Autowired
	ChairRepository chairRepository;
	
	@Override
	public CrudRepository<Chair, Integer> getRepo() {
		// TODO Auto-generated method stub
		return chairRepository;
	}

	@Override
	public List<Chair> retrieveAllChair() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chair retrieveChairById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chair retrieveChairByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Chair> retrieveChairByRouteId(int routeId) {
		//List<Chair> list = chairRepository.find
		return null;
	}

}
