package vn.fsoft.bookingbusticket.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import vn.fsoft.bookingbusticket.entity.AccountUser;
import vn.fsoft.bookingbusticket.entity.Role;
import vn.fsoft.bookingbusticket.entity.RoleName;
import vn.fsoft.bookingbusticket.exception.NotFoundException;
import vn.fsoft.bookingbusticket.repository.AccountUserRepository;
import vn.fsoft.bookingbusticket.repository.RoleRepository;
import vn.fsoft.bookingbusticket.service.AccountUserService;
@Service
@Component
public class AccountUserServiceImpl implements AccountUserService{

	@Autowired
	AccountUserRepository accountUserRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
//	@Autowired
//	CustomerRepository customerRepository;
//	
//	@Autowired
//	StaffRepository staffRepository;
	
	@Override
	public CrudRepository<AccountUser, Integer> getRepo() {
		// TODO Auto-generated method stub
		return accountUserRepository;
	}

	@Override
	public List<AccountUser> retrieveAllAccountUser() {
		List<AccountUser> list = accountUserRepository.findAll();
		
		if(list.isEmpty()) {
			throw new NotFoundException("Account user list not found!");
		}
		return list;
	}

	@Override
	public AccountUser retrieveAccountById(int id) {
		Optional<AccountUser> acc = accountUserRepository.findById(id);
		if(!acc.isPresent()) {
			throw new NotFoundException("Account not found!");
		}
		return acc.get();
	}

	@Override
	public AccountUser retrieveAccountByUserName(String userName) {
		Optional<AccountUser> account = accountUserRepository.findByUserName(userName);
		if(!account.isPresent()) {
			throw new NotFoundException("AccountUaer not found!");
		}
		return account.get();
	}

	@Override
	public AccountUser retrieveAccountByIdOrUserName(int id, String userName) {
		Optional<AccountUser> account = accountUserRepository.findByAccountIdOrUserName(id, userName);
		if(!account.isPresent()) {
			throw new NotFoundException("Account not found!");
		}
		return account.get();
	}

	@Override
	public AccountUser retrieveAccountByUserNameAndPassword(String userName, String password) {
		Optional<AccountUser> account = accountUserRepository.findByUserNameAndUserPassword(userName, password);
		if(!account.isPresent()) {
			throw new NotFoundException("Account not found!");
		}
		return account.get();
	}

	@Override
	public AccountUser addAccount(AccountUser accountUser) {
		return accountUserRepository.save(accountUser);
	}

	@Override
	public AccountUser registerAccount(AccountUser account) {
		AccountUser accountCreate=accountUserRepository.save(account);
		Role role = roleRepository.findByRoleName(RoleName.CUSTOMER).get();
		
		accountCreate.setRole(role);
		
		return accountUserRepository.save(accountCreate);
	}

	@Override
	public List<AccountUser> retrieveAllAccountUserByRoleId(int roleId) {
		return accountUserRepository.findAllByRoleId(roleId);
	}
	
	@Override
	public void updateRoleForAccountUser(int roleId,int accId) {
		accountUserRepository.updateRole(roleId, accId);
//		if(roleId==2) {
//		customerRepository.updateRole(roleId, accId);
//		}else {
//		staffRepository.updateRole(roleId, accId);
//		}
	}


}
