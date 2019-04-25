package vn.fsoft.bookingbusticket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import vn.fsoft.bookingbusticket.entity.Customer;
import vn.fsoft.bookingbusticket.entity.Staff;
import vn.fsoft.bookingbusticket.exception.NotFoundException;
import vn.fsoft.bookingbusticket.model.CustomerDto;
import vn.fsoft.bookingbusticket.repository.CustomerRepository;
import vn.fsoft.bookingbusticket.repository.StaffRepository;
import vn.fsoft.bookingbusticket.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	StaffRepository staffRepository;

	@Override
	public CrudRepository<Customer, Integer> getRepo() {
		// TODO Auto-generated method stub
		return customerRepository;
	}

	@Override
	public List<Customer> retrieveAllCustomer() {
		List<Customer> list = customerRepository.findAll();
		if (list.isEmpty()) {
			throw new NotFoundException("List customer not found!");
		}
		return list;
	}

	@Override
	public Customer retrieveCustomerByCustomerId(int custId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRoleForCustmerByCustomerId(int custId, int roleId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateInformationForCustomer(Customer cust) {

	}

	@Override
	public void updateRoleForAccountUser(int roleId, int accId) {
		customerRepository.updateRole(roleId, accId);
	}

	@Override
	public Customer setStafftoCustomer(int accId, int roleId) {
		Staff staff = staffRepository.findByAccountId(accId).get();
		CustomerDto cust = new CustomerDto();

		// cust.setCustId(staff.getStaffId());
		cust.setAddress(staff.getAddress());
		cust.setBalance(0);
		cust.setEmail(staff.getEmail());
		cust.setFullName(staff.getFullName());
		cust.setPhone(staff.getPhone());
		cust.setAccountId(staff.getAccountUser().getAccountId());
		cust.setRoleId(staff.getRole().getRoleId());
		Customer customer = new Customer(cust.getAddress(), cust.getBalance(), cust.getEmail(), cust.getFullName(),
				cust.getPhone(), staff.getAccountUser(), staff.getRole(), null, null);

		return customerRepository.save(customer);
	}

}
