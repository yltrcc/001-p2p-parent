package com.csg.p2p.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.csg.p2p.model.House;
import com.csg.p2p.model.Users;
import com.csg.p2p.service.IHouserService;
import com.csg.p2p.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
public class UserController {

	@Reference(interfaceClass = IUserService.class, version = "1.0.0", check = false, timeout = 15000)
	private IUserService service;
	@Reference(interfaceClass = IHouserService.class, version = "1.0.0", check = false, timeout = 15000)
	private IHouserService dao;
	
	@RequestMapping("/toUserSystem")
	public String toUserSystemPage() {
		return "jsp/customer";
	}
	
	@RequestMapping("/toUserRentalPage")
	public String toUserRentalPage() {
		return "jsp/myrental";
	}
	
	@RequestMapping("/welcome")
	public String toWelcomePage() {
		return "jsp/welcome";
	}
	
	@RequestMapping("/toUpdateHousePage")
	public String toUpdatePage(int hID,HttpServletRequest request) {
		House house = dao.findHouseDetailsById(hID);
		request.getSession().setAttribute("House", house);
		return "jsp/updatehouse";
	}
	
	@RequestMapping("/updateUserPwd")
	@ResponseBody
	public String updateUserPwd(String id,String newPwd,String oldPwd) {
		Users oldUser = new Users();
		oldUser.setuID(Integer.parseInt(id));
		oldUser.setuPassword(oldPwd);
		Users checkUser = service.checkOldPwd(oldUser);
		if(checkUser!=null) {
			Users newUser = new Users();
			newUser.setuID(Integer.parseInt(id));
			newUser.setuPassword(newPwd);
			int n = service.updateUserPwd(newUser);
			if(n>0) {
				return "OK";
			}
		}
		return "FAIL";
	}
}
