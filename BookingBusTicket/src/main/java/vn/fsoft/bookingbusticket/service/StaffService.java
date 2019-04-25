package vn.fsoft.bookingbusticket.service;

public interface StaffService {
	void updateRoleForAccountUser(int roleId,int accId);
	void deleteByAccountId(int accId);
}
