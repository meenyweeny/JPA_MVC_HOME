package com.ssafy.service.house;

import java.util.List;

import com.ssafy.dto.house.DongCodeDto;
import com.ssafy.dto.house.HouseDealDto;
import com.ssafy.dto.house.HouseInfoDto;

public interface HouseService {

	List<DongCodeDto> dongCodeList(String dongName);

	List<HouseInfoDto> searchByDongCode(int dongCode);

	List<HouseDealDto> searchByAptNo(String aptNo, int year, int month);

}
