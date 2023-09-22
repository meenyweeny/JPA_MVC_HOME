package com.ssafy.happyhouse.model.service;

import java.math.BigInteger;
import java.sql.*;
import java.util.*;

import com.ssafy.happyhouse.model.DongCodeDto;
import com.ssafy.happyhouse.model.HouseDealDto;
import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.util.DBUtil;

public class HouseServiceImpl implements HouseService {
	private DBUtil database = DBUtil.getInstance();
	@Override
	public List<DongCodeDto> dongCodeList(String dong) {
		List<DongCodeDto> list = new ArrayList<>();
		try {
			Connection con = database.getConnection();
			String query = "select * from dongcode where dongName like '%" + dong + "%'";
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(query);
	        while(rs.next()) {
	            String dongCode = rs.getString(1);
	            String sidoName = rs.getString(2);
	            String gugunName = rs.getString(3);
	            String dongName = rs.getString(4);
	            DongCodeDto data = new DongCodeDto();
	            data.setDongCode(dongCode);
	            data.setSidoName(sidoName);
	            data.setGugunName(gugunName);
	            data.setDongName(dongName);
	            list.add(data);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<HouseInfoDto> searchByDongCode(int dongCode) {
		List<HouseInfoDto> list = new ArrayList<>();
		try {
			Connection con = database.getConnection();
			String query = "select * from houseinfo where dongCode = " + dongCode + "";
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(query);
	        while(rs.next()) {
	        	list.add(new HouseInfoDto(rs.getString(1),
	        			Integer.parseInt(rs.getString(2)),rs.getString(3),
	        			rs.getString(4),rs.getString(5),rs.getString(6),
	        			rs.getString(7),rs.getString(8),rs.getString(9),
	        			rs.getString(10),rs.getString(11),rs.getString(12),
	        			rs.getString(13),rs.getString(14),rs.getString(15),
	        			rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(19)));
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<HouseDealDto> searchByAptNo(String aptNo, int year, int month) {
		List<HouseDealDto> list = new ArrayList<>();
		try {
			Connection con = database.getConnection();
			String query = "select * from housedeal " + 
			" where aptCode = " + aptNo + " and " +
					"dealYear = " + year + " and dealMonth = " + month;
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(query);
	        while(rs.next()) {
	        	list.add(new HouseDealDto(rs.getString(1),
	        			rs.getString(2),rs.getString(3),
	        			rs.getString(4),rs.getString(5),rs.getString(6),
	        			rs.getString(7),rs.getString(8),rs.getString(9)));
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}