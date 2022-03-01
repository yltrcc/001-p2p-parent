package com.csg.p2p.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.csg.p2p.model.*;
import com.csg.p2p.service.IOrderService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;


@Controller
public class OrderController {

	@Reference(interfaceClass = IOrderService.class, version = "1.0.0", check = false, timeout = 15000)
	private IOrderService sevice;
	
	@RequestMapping("/myorder")
	public String toOrderPage() {
		return "jsp/myorder";
	}
	
	@RequestMapping("/updatepwd")
	public String toUpdatepwdPage(HttpServletRequest request, Model model) {
		Users loginUser = (Users) request.getSession().getAttribute("loginUser");
		model.addAttribute("uID",loginUser.getuID());
		return "templates/updatepwd";
	}
	
	@RequestMapping("/addOrder")
	@ResponseBody
	public String addOrder(String id,HttpServletRequest request) {
		Users u = (Users) request.getSession().getAttribute("loginUser");
		try {
			Order order = new Order();
			order.sethID(Integer.parseInt(id));
			order.setOrderUser(u.getuNickName());
			order.setuID(u.getuID());
			int n = sevice.addOrder(order);
			if(n>0) {
				return "OK";
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return "FAIL";
	}
	
	@RequestMapping("/myOrderInfo")
	@ResponseBody
	public UserOrderData findAllOrder(int page, int limit, HttpServletRequest request){
		Page p = new Page();
		p.setPage((page - 1) * limit);
		p.setLimit(limit);
		Users u = (Users) request.getSession().getAttribute("loginUser");
		p.setuID(u.getuID());
		UserOrderData uod = new UserOrderData();
		List<UserOrder> order = sevice.findAllOrder(p);
		uod.setCode(0);
		uod.setCount(sevice.getOrderCount(u.getuID()));
		uod.setData(order);
		uod.setMsg("200");
		return  uod;
	}
	
	@RequestMapping("/deleteOrder")
	@ResponseBody
	public String deleteOrder(int oID) {
		int n = sevice.deleteOrder(oID);
		if(n>0)
			return "OK";
		return "FAIL";
	}
}
