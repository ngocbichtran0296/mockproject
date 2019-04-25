package vn.fsoft.bookingbusticket.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.fsoft.bookingbusticket.entity.AccountUser;
@Repository
public interface AccountUserRepository extends JpaRepository<AccountUser,Integer>{
	
	Optional<AccountUser> findByUserNameAndUserPassword(String name, String pass);
	
	Optional<AccountUser> findByUserName(String userName);
	
	Optional<AccountUser> findByAccountIdOrUserName(int accountId, String userName);
	
	@Query("select a from AccountUser a where a.role.roleId = ?1")
	//@Query(nativeQuery = true, value="select * from account_user where role_Id = ?1")
	List<AccountUser> findAllByRoleId(int roleId);
	
	@Transactional(readOnly=false)
	@Modifying
	@Query("update AccountUser a set a.role.roleId = :roleId where a.accountId= :accId")
	void updateRole(@Param("roleId")int roleId,@Param("accId")int accId);

}
