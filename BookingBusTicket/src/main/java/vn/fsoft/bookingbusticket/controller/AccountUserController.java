package vn.fsoft.bookingbusticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.fsoft.bookingbusticket.entity.AccountUser;
import vn.fsoft.bookingbusticket.entity.Role;
import vn.fsoft.bookingbusticket.entity.RoleName;
import vn.fsoft.bookingbusticket.repository.AccountUserRepository;
import vn.fsoft.bookingbusticket.repository.RoleRepository;

@Component
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AccountUserController {
	@Autowired
	AccountUserRepository userrepo;
	
	@Autowired
	RoleRepository rolerepository;
	
	@GetMapping("/users")
	public List<AccountUser> getAlluser(){
		System.out.println("Get All Customers");	
		return userrepo.findAll();
		
	}
	
	@GetMapping("/user")
	public AccountUser getUser(@RequestParam int id) {
		return userrepo.findById(id).get();
	}
	
	@PostMapping(value = "/create")
	public AccountUser createUsers(@RequestBody AccountUser users,@RequestBody Role r) {
		System.out.println(users.getRole());
		Role role = rolerepository.findByRoleName(RoleName.CUSTOMER).get();
		AccountUser _users = userrepo.save(new AccountUser(users.getUserPassword(),
				users.getUserName(),role));
		return _users;
	}
	
	@PostMapping(value = "/create/customer")
	public AccountUser createCustomers(@RequestBody AccountUser users) {
		System.out.println(users.getRole());		
		Role role = new Role(3,"customer");
		return userrepo.save(new AccountUser(users.getUserName(),users.getUserPassword(),role));
	}

}
