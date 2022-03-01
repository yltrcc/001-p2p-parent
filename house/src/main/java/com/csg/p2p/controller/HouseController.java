package com.csg.p2p.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.csg.p2p.model.House;
import com.csg.p2p.model.Page;
import com.csg.p2p.model.UserHouseData;
import com.csg.p2p.model.Users;
import com.csg.p2p.service.IHouserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class HouseController {

	@Reference(interfaceClass = IHouserService.class, version = "1.0.0", check = false, timeout = 15000)
	private IHouserService service;
	
	@RequestMapping("/findUserHouse")
	@ResponseBody
	public UserHouseData houseByUser(HttpServletRequest request, int page, int limit) {
		Page p = new Page();
		Users u = (Users) request.getSession().getAttribute("loginUser");
		String publisher = u.getuNickName();
		p.setPublisher(publisher);
		p.setLimit(limit);
		p.setPage((page - 1) * limit);
		List<House> list = service.findHouseByUser(p);
		System.out.println(list);
		UserHouseData data = new UserHouseData(0, "200", list.size(), list);
		return data;
	}
	
	@RequestMapping("/deleteUserHouse")
	@ResponseBody
	public String deleteUserHouse(String hID) {
		int n = service.deleteUserHouse(Integer.parseInt(hID));
		if(n>0) {
			return "OK";
		}
		return "FAIL";
	}
	
	@RequestMapping("/updateHouse")
	@ResponseBody
	public String updateHouse(House house) {
		int n = service.updateHouse(house);
		if(n>0)
			return "OK";
		return "FAIL";
	}

	/**
	 * 数据审核通过
	 * @param house
	 * @return
	 */
	@RequestMapping("/passAuditHouse")
	@ResponseBody
	public String passAuditHouse(House house) {
		house.setPassAudit(1);
		int n = service.passAuditHouse(house);
		if(n>0)
			return "OK";
		return "FAIL";
	}

	/**
	 * 数据审核通过
	 * @param house
	 * @return
	 */
	@RequestMapping("/noPassAuditHouse")
	@ResponseBody
	public String noPassAuditHouse(House house) {
		house.setPassAudit(0);
		int n = service.noPassAuditHouse(house);
		if(n>0)
			return "OK";
		return "FAIL";
	}
}
