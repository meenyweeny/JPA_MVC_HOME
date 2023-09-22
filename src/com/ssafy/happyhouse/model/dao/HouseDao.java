package com.ssafy.happyhouse.model.dao;

import java.util.List;

import com.ssafy.happyhouse.model.DongCodeDto;
import com.ssafy.happyhouse.model.HouseDealDto;
import com.ssafy.happyhouse.model.HouseInfoDto;

public interface HouseDao {

	List<DongCodeDto> dongCodeList(String dongName);

	List<HouseInfoDto> searchByDongCode(int dongCode);

	List<HouseDealDto> searchByAptNo(long aptNo, int year, int month);
	
}
