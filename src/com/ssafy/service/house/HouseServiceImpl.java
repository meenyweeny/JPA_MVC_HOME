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
	public List<HouseDealDto> searchByAptNo(long aptNo, int year, int month) {
		return houseDao.searchByAptNo(aptNo, year, month);
	}

	@Override
	public List<String> AllSido() {
		return houseDao.AllSido();
	}

	@Override
	public List<String> AllDYear() {
		return houseDao.AllDYear();
	}

	@Override
	public List<String> GetDong(String gugun) {
		return houseDao.GetDong(gugun);
	}

	@Override
	public List<String> GetGugun(String sido) {
		return houseDao.GetGugun(sido);
	}

	@Override
	public List<String[]> searchByDYM(String dong, String year, String month) {
		return houseDao.searchByDYM(dong, year, month);
	}

}