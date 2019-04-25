package vn.fsoft.bookingbusticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.fsoft.bookingbusticket.entity.Deposit;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Integer>{

}
