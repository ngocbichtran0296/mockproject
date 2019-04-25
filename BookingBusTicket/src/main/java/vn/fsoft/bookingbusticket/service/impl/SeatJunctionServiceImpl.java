package vn.fsoft.bookingbusticket.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import vn.fsoft.bookingbusticket.entity.SeatJunction;
import vn.fsoft.bookingbusticket.exception.NotFoundException;
import vn.fsoft.bookingbusticket.model.ChairDto;
import vn.fsoft.bookingbusticket.repository.SeatJunctionRepository;
import vn.fsoft.bookingbusticket.service.SeatJunctionService;

@Service
public class SeatJunctionServiceImpl implements SeatJunctionService{
	@Autowired
	SeatJunctionRepository seatJunctionRepository;
	
	@Override
	public CrudRepository<SeatJunction, Integer> getRepo() {
		// TODO Auto-generated method stub
		return seatJunctionRepository;
	}

	@Override
	public List<SeatJunction> getSeatJunctionByRouteId(int routeId) {
		List<SeatJunction> list = seatJunctionRepository.findSeatJunctionByRouteId(routeId);
		if(list.isEmpty()) {
			throw new NotFoundException("SeatJunction not found!");
		}
		return list; 
	}

	@Override
	public List<ChairDto> getChairByRouteId(int routeId) {
		List<ChairDto> chairDtoList=new ArrayList<>();
		List<SeatJunction> seatJuncList= getSeatJunctionByRouteId(routeId);
		ChairDto chair;
		for(SeatJunction s : seatJuncList) {
			chair=new ChairDto();
			
			chair.setChairId(s.getChair().getChairId());
			chair.setChairName(s.getChair().getChairName());
			chair.setStatus(s.getChairStatus()==0?0:1);
			chair.setRouteId(s.getRoute().getRoutesId());
			chair.setBusId(s.getRoute().getBusId());
			
			chairDtoList.add(chair);
		}
		return chairDtoList;
	}
	
}
