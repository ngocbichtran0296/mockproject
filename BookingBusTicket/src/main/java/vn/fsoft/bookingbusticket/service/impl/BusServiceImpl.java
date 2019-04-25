package vn.fsoft.bookingbusticket.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import vn.fsoft.bookingbusticket.entity.Bus;
import vn.fsoft.bookingbusticket.exception.NotFoundException;
import vn.fsoft.bookingbusticket.repository.BusRepository;
import vn.fsoft.bookingbusticket.service.BusService;

@Service
public class BusServiceImpl implements BusService {
	@Autowired
	BusRepository busRepository;
	
	@Override
	public CrudRepository<Bus, Integer> getRepo() {
		// TODO Auto-generated method stub
		return busRepository;
	}

	@Override
	public Bus retrieveBusById(int id) {
		Optional<Bus> bus=busRepository.findById(id);
		if(!bus.isPresent()) {
			throw new NotFoundException("Bus not found!");
		}
		return bus.get();
	}

	@Override
	public List<Bus> retrieveAllBus() {
		List<Bus> busList =busRepository.findAll();
		if(busList.isEmpty()) {
			throw new NotFoundException("Bus List not found!");
		}
		return busList;
	}

	@Override
	public Bus addBus(Bus bus) {
		// TODO Auto-generated method stub
		return busRepository.save(bus);
	}

	@Override
	public Bus retrieveBusByName(String busName) {
		Optional<Bus> bus=busRepository.findByBusName(busName);
		if(!bus.isPresent()) {
			throw new NotFoundException("Bus not found!");
		}
		return bus.get(); 
	}

	@Override
	public String getBusNameById(int busId) {
		String name = busRepository.findBusNameByBusId(busId);
		if(name.equals("")) {
			throw new NotFoundException("Bus not found!");
		}
		return name;
	}

	

}
