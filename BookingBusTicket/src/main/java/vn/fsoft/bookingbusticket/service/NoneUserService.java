package vn.fsoft.bookingbusticket.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import vn.fsoft.bookingbusticket.entity.Noneuser;

public interface NoneUserService {
	CrudRepository<Noneuser, Integer> getRepo();

	List<Noneuser> retrieveAllNoneUsers();

	void updateNoneUser(Noneuser NoneUse);

	Noneuser retrieveNoneUserByIdOrFullName(int id, String NoneUserName);

	Noneuser retrieveNoneUserById(int uId);

	Noneuser retrieveNoneUserByNoneUserFullName(String NoneUserFullName);

	Noneuser registerNoneUser(Noneuser NoneUser);
}
