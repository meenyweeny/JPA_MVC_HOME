package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.DongCodeDto;
import com.ssafy.happyhouse.model.HouseDealDto;
import com.ssafy.happyhouse.model.HouseInfoDto;

public interface HouseService {

	List<DongCodeDto> dongCodeList(String dongName);

	List<HouseInfoDto> searchByDongCode(int dongCode);

	List<HouseDealDto> searchByAptNo(String aptNo, int year, int month);

}
