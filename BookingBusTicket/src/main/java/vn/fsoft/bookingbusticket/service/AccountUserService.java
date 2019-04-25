package vn.fsoft.bookingbusticket.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import vn.fsoft.bookingbusticket.entity.AccountUser;

public interface AccountUserService {
	
	CrudRepository<AccountUser, Integer> getRepo();
	
	List<AccountUser> retrieveAllAccountUser();
	
	List<AccountUser> retrieveAllAccountUserByRoleId(int roleId);
	
	AccountUser retrieveAccountById(int id);
	
	AccountUser retrieveAccountByUserName(String userName);
	
	AccountUser retrieveAccountByIdOrUserName(int id, String userName);
	
	AccountUser retrieveAccountByUserNameAndPassword(String userName, String password);
	
	AccountUser addAccount(AccountUser accountUser);
	
	void updateRoleForAccountUser(int idAccount, int idRole);
	
	AccountUser registerAccount(AccountUser account);
		
}
