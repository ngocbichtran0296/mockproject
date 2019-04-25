package vn.fsoft.bookingbusticket.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import vn.fsoft.bookingbusticket.entity.Noneuser;
import vn.fsoft.bookingbusticket.exception.*;
import vn.fsoft.bookingbusticket.repository.NoneUserRepository;
import vn.fsoft.bookingbusticket.service.NoneUserService;

@Service
public class NoneUserServiceImpl implements NoneUserService {
	@Autowired
	NoneUserRepository noneUserRepository;

	@Override
	public CrudRepository<Noneuser, Integer> getRepo() {
		// TODO Auto-generated method stub
		return noneUserRepository;
	}

	@Override
	public List<Noneuser> retrieveAllNoneUsers() {
		List<Noneuser> noneUsers = noneUserRepository.findAll();
		if (noneUsers.isEmpty()) {
			throw new NotFoundException("Users not found");
		}
		return noneUsers;
	}

	@Override
	public void updateNoneUser(Noneuser noneUser) {
		noneUserRepository.save(noneUser);
	}

	@Override
	public Noneuser retrieveNoneUserByIdOrFullName(int id, String NoneUserName) {
		Optional<Noneuser> noneUser = noneUserRepository.findByIdOrFullName(id, NoneUserName);
		if (!noneUser.isPresent()) {
			throw new NotFoundException("NoneUser not found!");
		}
		return noneUser.get();
	}

	@Override
	public Noneuser retrieveNoneUserById(int uId) {
		Optional<Noneuser> noneUser = noneUserRepository.findById(uId);
		if (!noneUser.isPresent()) {
			throw new NotFoundException("NoneUser not found!");
		}
		return noneUser.get();
	}

	@Override
	public Noneuser retrieveNoneUserByNoneUserFullName(String NoneUserFullName) {
		Optional<Noneuser> noneUser = noneUserRepository.findByFullName(NoneUserFullName);

		if (!noneUser.isPresent()) {
			throw new NotFoundException("NoneUser not found!");
		}
		return noneUser.get();
	}

	@Override
	public Noneuser registerNoneUser(Noneuser NoneUser) {
		return noneUserRepository.save(NoneUser);
	}

}
