package com.csg.p2p.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.csg.p2p.mapper.HouseMapper;
import com.csg.p2p.model.House;
import com.csg.p2p.model.Page;
import com.csg.p2p.service.IHouserService;
import com.csg.p2p.service.user.FinanceAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Service(interfaceClass = IHouserService.class, version = "1.0.0", timeout = 15000)
public class HouserServiceImpl implements IHouserService {

	@Autowired
	private HouseMapper dao;
	
	@Override
	public List<House> findHomeInfo() {
		return dao.findHomeInfo();
	}

	@Override
	public House findHouseDetailsById(int id) {
		return dao.findHouseDetailsById(id);
	}

	@Override
	public int addNewHouse(House house) {
		return dao.addNewHouse(house);
	}

	@Override
	public List<House> findHouseByUser(Page page) {
		return dao.findHouseByUser(page);
	}
	
	@Override
	public int deleteUserHouse(int hID) {
		return dao.deleteUserHouse(hID);
	}
	@Override
	public int updateHouse(House house) {
		return dao.updateHouse(house);
	}
	@Override
	public int passAuditHouse(House house) {
		return dao.passAuditHouse(house);
	}
	@Override
	public int noPassAuditHouse(House house) {
		return dao.noPassAuditHouse(house);
	}
	@Override
	public List<House> findHouseByLike(String keywords) {
		return dao.findHouseByLike(keywords);
	}
	@Override
	public List<House> findHouseOrderByAsc() {
		return dao.findHouseOrderByAsc();
	}
	@Override
	public List<House> findHouseOrderByDesc() {
		return dao.findHouseOrderByDesc();
	}
}
