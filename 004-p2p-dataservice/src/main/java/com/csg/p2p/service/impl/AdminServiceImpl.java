package com.csg.p2p.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.csg.p2p.mapper.AdminMapper;
import com.csg.p2p.model.Admin;
import com.csg.p2p.model.House;
import com.csg.p2p.model.Page;
import com.csg.p2p.model.Users;
import com.csg.p2p.service.IAdminService;
import com.csg.p2p.service.loan.BidInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service(interfaceClass = IAdminService.class, version = "1.0.0",  timeout = 15000)
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private AdminMapper service;

	@Override
	public Admin adminAccess(Admin admin) {
		return service.adminAccess(admin);
	}

	@Override
	public List<Users> findAllUser() {
		return service.findAllUser();
	}

	@Override
	public List<House> findAllHouse(Page page) {
		return service.findAllHouse(page);
	}

	@Override
	public List<House> findPassHouse(Page page) {
		return service.findPassHouse(page);
	}

	@Override
	public int deleteHouse(int hID) {
		return service.deleteHouse(hID);
	}

	@Override
	public Users findUserById(int uID) {
		return service.findUserById(uID);
	}

	@Override
	public int updateUser(Users users) {
		return service.updateUser(users);
	}
	@Override
	public int deleteUser(int uID) {
		return service.deleteUser(uID);
	}
	@Override
	public Admin checkAdminPwd(Admin admin) {
		return service.checkAdminPwd(admin);
	}
	@Override
	public int updateAdminPwd(Admin admin) {
		return service.updateAdminPwd(admin);
	}
}
