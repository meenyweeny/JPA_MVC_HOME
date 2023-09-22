package com.ssafy.dao.house;

import java.util.List;

import com.ssafy.dto.house.DongCodeDto;
import com.ssafy.dto.house.HouseDealDto;
import com.ssafy.dto.house.HouseInfoDto;

public interface HouseDao {

	List<DongCodeDto> dongCodeList(String dongName);

	List<HouseInfoDto> searchByDongCode(int dongCode);

	List<HouseDealDto> searchByAptNo(long aptNo, int year, int month);
	
}
