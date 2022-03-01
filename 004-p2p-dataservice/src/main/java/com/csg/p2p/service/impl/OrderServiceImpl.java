package com.csg.p2p.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.csg.p2p.mapper.OrderMapper;
import com.csg.p2p.model.Order;
import com.csg.p2p.model.Page;
import com.csg.p2p.model.UserOrder;
import com.csg.p2p.service.IHouserService;
import com.csg.p2p.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service(interfaceClass = IOrderService.class, version = "1.0.0", timeout = 15000)
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderMapper mapper;
	
	@Override
	public int addOrder(Order order) {
		return mapper.addOrder(order);
	}

	@Override
	public List<UserOrder> findAllOrder(Page page) {
		return mapper.findAllOrder(page);
	}

	@Override
	public int getOrderCount(int uID) {
		return mapper.getOrderCount(uID);
	}

	@Override
	public int deleteOrder(int oID) {
		return mapper.deleteOrder(oID);
	}

}
