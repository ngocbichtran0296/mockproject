package vn.fsoft.bookingbusticket.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import vn.fsoft.bookingbusticket.entity.Ticket;
import vn.fsoft.bookingbusticket.exception.NotFoundException;
import vn.fsoft.bookingbusticket.model.TicketDto;
import vn.fsoft.bookingbusticket.repository.BusRepository;
import vn.fsoft.bookingbusticket.repository.RouteRepository;
import vn.fsoft.bookingbusticket.repository.TicketRepository;
import vn.fsoft.bookingbusticket.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	TicketRepository ticketRepository;

	@Autowired
	RouteRepository routeRepository;

	@Autowired
	BusRepository busRepository;

	@Override
	public CrudRepository<Ticket, Integer> getRepo() {
		// TODO Auto-generated method stub
		return ticketRepository;
	}

	@Override
	public List<TicketDto> retrieveAllTicket() {
		List<Ticket> list = ticketRepository.findAll();
		List<TicketDto> listTicketDto = new ArrayList<>();
		TicketDto ticket;
		int routeId = 0;
		if (list.isEmpty()) {
			throw new NotFoundException("List ticket not found!");
		} else {
			for (Ticket t : list) {
				routeId = t.getRoute().getRoutesId();
				ticket = new TicketDto();

				ticket.setTicketId(t.getTicketId());
				ticket.setBusId(routeRepository.findById(routeId).get().getBusId());
				ticket.setBusName(busRepository.findById(ticket.getBusId()).get().getBusName());
				ticket.setChairId(t.getSeatJunction().getChair().getChairId());
				ticket.setChairName(t.getSeatJunction().getChair().getChairName());
				ticket.setCustId(t.getCustomer().getCustId());
				ticket.setCustName(t.getCustomer().getFullName());
				ticket.setBookingDate(t.getBookingDate());
				ticket.setBookingTime(t.getBookingTime());
				ticket.setDeparture(routeRepository.findById(routeId).get().getDepartture());
				ticket.setFromPlace(routeRepository.findById(routeId).get().getPlace1().getPlaceName());
				ticket.setToPlace(routeRepository.findById(routeId).get().getPlace2().getPlaceName());
				ticket.setNoneUserId(t.getNoneuser().getId());
				ticket.setNoneUserName(t.getNoneuser().getFullName());
				ticket.setStartDate(routeRepository.findById(routeId).get().getStartDate());
				ticket.setRouteId(routeId);
				ticket.setTicketStatus(t.getSeatJunction().getChairStatus());

				listTicketDto.add(ticket);
			}
		}
		return listTicketDto;
	}

	@Override
	public TicketDto retriveTicketByTicketId(int ticketId) {
		Ticket t = ticketRepository.findById(ticketId).get();
		TicketDto ticket = new TicketDto();
		if (t == null) {
			throw new NotFoundException("Ticket not found!");
		} else {
			int routeId = t.getRoute().getRoutesId();
			ticket = new TicketDto();

			ticket.setTicketId(t.getTicketId());
			ticket.setBusId(routeRepository.findById(routeId).get().getBusId());
			ticket.setBusName(busRepository.findById(ticket.getBusId()).get().getBusName());
			ticket.setChairId(t.getSeatJunction().getChair().getChairId());
			ticket.setChairName(t.getSeatJunction().getChair().getChairName());
			ticket.setCustId(t.getCustomer().getCustId());
			ticket.setCustName(t.getCustomer().getFullName());
			ticket.setBookingDate(t.getBookingDate());
			ticket.setBookingTime(t.getBookingTime());
			ticket.setDeparture(routeRepository.findById(routeId).get().getDepartture());
			ticket.setFromPlace(routeRepository.findById(routeId).get().getPlace1().getPlaceName());
			ticket.setToPlace(routeRepository.findById(routeId).get().getPlace2().getPlaceName());
			ticket.setNoneUserId(t.getNoneuser().getId());
			ticket.setNoneUserName(t.getNoneuser().getFullName());
			ticket.setStartDate(routeRepository.findById(routeId).get().getStartDate());
			ticket.setRouteId(routeId);
			ticket.setTicketStatus(t.getSeatJunction().getChairStatus());
		}
		return ticket;
	}

	@Override
	public List<TicketDto> retrieveTicketByTicketStatus(int ticketStatus) {
		List<Ticket> ticketList = ticketRepository.findByTicketStatus(ticketStatus);
		if (ticketList.isEmpty()) {
			throw new NotFoundException("Not found Ticket list by Status!");
		}
		return null;
	}

	@Override
	public List<TicketDto> retrieveTicketByCustIdAndStatus(int custId, int status) {
		List<Ticket> list = ticketRepository.findTicketByCustomerIdAndTicketStatus(custId, status);
		List<TicketDto> listTicket = new ArrayList<>();
		if (list.isEmpty()) {
			throw new NotFoundException("Not found list ticket by custId and static!");
		} else {
			TicketDto ticket = new TicketDto();
			int routeId = 0;
			for (Ticket t : list) {
				routeId = t.getRoute().getRoutesId();
				ticket = new TicketDto();

				ticket.setTicketId(t.getTicketId());
				ticket.setBusId(routeRepository.findById(routeId).get().getBusId());
				ticket.setBusName(busRepository.findById(ticket.getBusId()).get().getBusName());
				ticket.setChairId(t.getSeatJunction().getChair().getChairId());
				ticket.setChairName(t.getSeatJunction().getChair().getChairName());
				ticket.setCustId(t.getCustomer().getCustId());
				ticket.setCustName(t.getCustomer().getFullName());
				ticket.setBookingDate(t.getBookingDate());
				ticket.setBookingTime(t.getBookingTime());
				ticket.setDeparture(routeRepository.findById(routeId).get().getDepartture());
				ticket.setFromPlace(routeRepository.findById(routeId).get().getPlace1().getPlaceName());
				ticket.setToPlace(routeRepository.findById(routeId).get().getPlace2().getPlaceName());
				ticket.setNoneUserId(t.getNoneuser().getId());
				ticket.setNoneUserName(t.getNoneuser().getFullName());
				ticket.setStartDate(routeRepository.findById(routeId).get().getStartDate());
				ticket.setRouteId(routeId);
				ticket.setTicketStatus(t.getSeatJunction().getChairStatus());

				listTicket.add(ticket);
			}
		}
		return listTicket;
	}

	@Override
	public List<TicketDto> retrieveTicketByNoneUserId(int id) {
		List<Ticket> list = ticketRepository.findByTicketByNoneUserId(id);
		if (list.isEmpty()) {
			throw new NotFoundException("List ticket by NoneUserId not found!");
		} else {
			for(Ticket t: list) {
				
			}
		}
		return null;
	}

	@Override
	public List<TicketDto> retrieveTicketByRouteId(int routeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
