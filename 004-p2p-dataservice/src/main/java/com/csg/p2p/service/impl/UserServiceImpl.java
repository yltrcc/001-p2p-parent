package com.csg.p2p.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.csg.p2p.mapper.UserMapper;
import com.csg.p2p.model.Users;
import com.csg.p2p.service.IOrderService;
import com.csg.p2p.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = IUserService.class, version = "1.0.0", timeout = 15000)
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper mapper;
	
	@Override
	public Users login(Users user) {
		return mapper.login(user);
	}

	@Override
	public int regist(Users user) {
		return mapper.regist(user);
	}

	@Override
	public int updateUserPwd(Users users) {
		return mapper.updateUserPwd(users);
	}

	@Override
	public Users checkOldPwd(Users users) {
		return mapper.checkOldPwd(users);
	}
}
