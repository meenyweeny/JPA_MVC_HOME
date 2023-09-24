package com.ssafy.service.house;

import java.util.List;

import com.ssafy.dto.house.DongCodeDto;
import com.ssafy.dto.house.HouseDealDto;
import com.ssafy.dto.house.HouseInfoDto;

public interface HouseService {

	List<DongCodeDto> dongCodeList(String dongName);

	List<HouseInfoDto> searchByDongCode(int dongCode);

	List<HouseDealDto> searchByAptNo(long aptNo, int year, int month);

	List<String> AllSido();

	List<String> AllDYear();

	List<String> GetDong(String gugun);

	List<String> GetGugun(String sido);

	List<String[]> searchByDYM(String dong, String year, String month);

}
