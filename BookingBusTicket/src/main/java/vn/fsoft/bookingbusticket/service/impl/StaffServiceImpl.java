package vn.fsoft.bookingbusticket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import vn.fsoft.bookingbusticket.repository.StaffRepository;
import vn.fsoft.bookingbusticket.service.StaffService;

@Service
@Component
public class StaffServiceImpl implements StaffService{
	@Autowired
	StaffRepository staffRepository;

	@Override
	public void updateRoleForAccountUser(int roleId, int accId) {
		staffRepository.updateRole(roleId, accId);
	}

	@Override
	public void deleteByAccountId(int accId) {
		staffRepository.deleteStaffByAccountId(accId);	
	}

}
