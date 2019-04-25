package vn.fsoft.bookingbusticket.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.fsoft.bookingbusticket.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	Optional<Customer> findByCustId(int id);
	
	@Transactional(readOnly=false)
	@Modifying
	@Query("update Customer a set a.role.roleId = :roleId where a.accountUser.accountId= :accId")
	void updateRole(@Param("roleId")int roleId,@Param("accId")int accId);
	
	//chua` nha may`: Customer setStafftoCustomer(int accId, int roleId);

}
