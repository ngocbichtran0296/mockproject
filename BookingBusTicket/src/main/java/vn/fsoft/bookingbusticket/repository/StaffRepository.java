package vn.fsoft.bookingbusticket.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.fsoft.bookingbusticket.entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer>{
	@Transactional(readOnly=false)
	@Modifying
	@Query("update Staff a set a.role.roleId = :roleId where a.accountUser.accountId= :accId")
	void updateRole(@Param("roleId")int roleId,@Param("accId")int accId);
	
	@Transactional(readOnly=false)
	@Modifying
	@Query("delete from Staff a where a.accountUser.accountId= :accId")
	void deleteStaffByAccountId(@Param("accId")int accId);
	
	@Query("select a from Staff a where a.accountUser.accountId= :accId")
	Optional<Staff> findByAccountId(@Param("accId")int accId);

}
