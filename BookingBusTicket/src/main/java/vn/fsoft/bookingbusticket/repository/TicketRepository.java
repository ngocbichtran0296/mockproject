package vn.fsoft.bookingbusticket.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.fsoft.bookingbusticket.entity.Customer;
import vn.fsoft.bookingbusticket.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>{
	List<Ticket> findByCustomer(Customer cust);
	List<Ticket> findByTicketStatus(int ticketStatus);
	
	@Query("SELECT t FROM Ticket t \r\n" + "WHERE t.customer.custId = :customerId")
	List<Ticket> findTicketByCustomerId(@Param("customerId") int customerId);
	
	@Query("SELECT t FROM Ticket t \r\n"+ "WHERE t.customer.custId = :customerId \n" + "AND t.ticketStatus = :status")
	List<Ticket> findTicketByCustomerIdAndTicketStatus(@Param("customerId")int cutomerId, @Param("status")int status);
	
	@Query("SELECT t FROM Ticket t \r\n"+"WHERE t.noneuser.id = :noneUserId")
	List<Ticket> findByTicketByNoneUserId(@Param("noneUserId") int noneUserId);
}
