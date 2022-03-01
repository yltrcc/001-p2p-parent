package com.csg.p2p.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.csg.p2p.model.House;
import com.csg.p2p.service.IHouserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
public class HouseDetailsController {

	@Reference(interfaceClass = IHouserService.class, version = "1.0.0", check = false, timeout = 15000)
	private IHouserService service;
	
	@RequestMapping("/toDetailsPage")
	public String toDetailsPage(int id,HttpServletRequest request) {
		House HouseDetails = service.findHouseDetailsById(id);
		List<String> list = new ArrayList<String>();
		String[] split = HouseDetails.getHouseDetailsImg().split("~");
		for(int i=0;i<split.length;i++) {
			list.add(split[i]);
		}
		request.getSession().setAttribute("Details", HouseDetails);
		request.getSession().setAttribute("DetailsImg", list);
		return "jsp/housedetails";
	}
}
