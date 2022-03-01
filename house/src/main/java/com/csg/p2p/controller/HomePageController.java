package com.csg.p2p.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.csg.p2p.model.House;
import com.csg.p2p.service.IHouserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomePageController {

	@Reference(interfaceClass = IHouserService.class, version = "1.0.0", check = false, timeout = 15000)
	private IHouserService service;

	@RequestMapping("/")
	public String home(HttpServletRequest request) {
		List<House> findHomeInfo = service.findHomeInfo();
		request.getSession().setAttribute("House", findHomeInfo);
		return "jsp/index";
	}
	
	@RequestMapping("/toIndexPage")
	public String toIndexPage(HttpServletRequest request) {
		List<House> findHomeInfo = service.findHomeInfo();
		request.getSession().setAttribute("House", findHomeInfo);
		return "jsp/index";
	}
	
	@RequestMapping("/findHouseByLike")
	public String findHouseByLike(HttpServletRequest request,String keywords) {
		List<House> findHomeInfo = service.findHouseByLike(keywords);
		request.getSession().removeAttribute("House");
		request.getSession().setAttribute("House", findHomeInfo);
		return "jsp/index";
	}
	
	@RequestMapping("/findHousrOrderByAsc")
	public String findHousrOrderByAsc(HttpServletRequest request) {
		List<House> findHomeInfo = service.findHouseOrderByAsc();
		request.getSession().removeAttribute("House");
		request.getSession().setAttribute("House", findHomeInfo);
		return "jsp/index";
	}
	
	@RequestMapping("/findHousrOrderByDesc")
	public String findHousrOrderByDesc(HttpServletRequest request) {
		List<House> findHomeInfo = service.findHouseOrderByDesc();
		request.getSession().removeAttribute("House");
		request.getSession().setAttribute("House", findHomeInfo);
		return "jsp/index";
	}
}
