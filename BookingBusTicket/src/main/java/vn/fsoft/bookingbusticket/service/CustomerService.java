package vn.fsoft.bookingbusticket.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import vn.fsoft.bookingbusticket.entity.Customer;

public interface CustomerService {
	CrudRepository<Customer, Integer> getRepo();
	
	List<Customer> retrieveAllCustomer();
	
	Customer retrieveCustomerByCustomerId(int custId);
	
	Customer addCustomer(Customer customer);
	
	void updateRoleForCustmerByCustomerId(int custId, int roleId);
	
	void updateInformationForCustomer(Customer cust);
	
	void updateRoleForAccountUser(int roleId,int accId);

	Customer setStafftoCustomer(int accId, int roleId);

}
