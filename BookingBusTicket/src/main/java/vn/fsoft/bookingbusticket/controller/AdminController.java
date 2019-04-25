package vn.fsoft.bookingbusticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.fsoft.bookingbusticket.entity.AccountUser;
import vn.fsoft.bookingbusticket.entity.Role;
import vn.fsoft.bookingbusticket.service.AccountUserService;
import vn.fsoft.bookingbusticket.service.CustomerService;
import vn.fsoft.bookingbusticket.service.StaffService;

@Component
@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins="http://localhost:4200")
public class AdminController {
	@Autowired
	AccountUserService accountService;
	
	@Autowired
	CustomerService customerService;

	@Autowired
	StaffService staffService;

	
	@GetMapping("/listAccount")
	public List<AccountUser> getAllAccount(){
		System.out.println("Get all account");
		List<AccountUser> list = accountService.retrieveAllAccountUser();
		return list;
	}
	
	@GetMapping("/user")
	public AccountUser getUser(@RequestParam int id) {
		return accountService.retrieveAccountById(id);
	}
	
	@PostMapping(value = "/create/ticketseller")
	public AccountUser createTicketSeller(@RequestBody AccountUser users) {
		System.out.println(users.getRole());
		Role role = new Role(2, "ticketseller");
		return accountService.addAccount(new AccountUser(users.getUserName(), users.getUserPassword(), role));
	}
	
	@PostMapping(value = "/create/admin")
	public AccountUser createAdmin(@RequestBody AccountUser users) {
		System.out.println(users.getRole());
//		Role role = rolerepository.findByRoleName(RoleName.CUSTOMER).get();
//		AccountUser _users = userrepo.save(new AccountUser(users.getUserPassword(),
//				users.getUserName(),role));
//		return _users;		
		Role role = new Role(3, "admin");
		return accountService.addAccount(new AccountUser(users.getUserName(), users.getUserPassword(), role));
	}

	@PostMapping(value = "/findById/{id}")
	public AccountUser searchById(@PathVariable int id) {
		return accountService.retrieveAccountById(id);
	}

	@PostMapping(value = "/findByRoleId/{id}")
	public List<AccountUser> filterByRole(@PathVariable int id) {
		return accountService.retrieveAllAccountUserByRoleId(id);
	}

	@PostMapping(value = "/setRole")
	public void setRole(@RequestParam int roleId, @RequestParam int accId) {
		accountService.updateRoleForAccountUser(roleId, accId);
		if (roleId == 3) {
			customerService.setStafftoCustomer(accId, roleId);
			//staffService.deleteByAccountId(accId);
		} else {
			customerService.updateRoleForAccountUser(roleId, accId);
		}

	}

}
