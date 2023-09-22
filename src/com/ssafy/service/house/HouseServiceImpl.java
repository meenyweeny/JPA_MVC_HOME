package com.ssafy.service.house;

import java.sql.*;
import java.util.*;

import com.ssafy.dao.house.HouseDao;
import com.ssafy.dao.house.HouseDaoImpl;
import com.ssafy.dto.house.DongCodeDto;
import com.ssafy.dto.house.HouseDealDto;
import com.ssafy.dto.house.HouseInfoDto;
import com.ssafy.util.DBUtil;

public class HouseServiceImpl implements HouseService {
	HouseDao houseDao;
	
	public HouseServiceImpl() {
		houseDao = new HouseDaoImpl();
	}
	
	@Override
	public List<DongCodeDto> dongCodeList(String dongName) {
		return houseDao.dongCodeList(dongName);
	}

	@Override
	public List<HouseInfoDto> searchByDongCode(int dongCode) {
		return houseDao.searchByDongCode(dongCode);
	}

	@Override
	public List<HouseDealDto> searchByAptNo(String aptNo, int year, int month) {
		return searchByAptNo(aptNo, year, month);
	}

}