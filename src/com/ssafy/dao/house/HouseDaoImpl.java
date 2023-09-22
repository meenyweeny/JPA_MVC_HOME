package com.ssafy.dao.house;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.house.*;
import com.ssafy.util.DBUtil;

public class HouseDaoImpl implements HouseDao {
	private DBUtil database = DBUtil.getInstance();

	@Override
	public List<DongCodeDto> dongCodeList(String dongName) {
		List<DongCodeDto> list = new ArrayList<>();
		try {
			Connection con = database.getConnection();
			String query = "select * from dongcode where dongName like '%" + dongName + "%'";
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(query);
	        while(rs.next()) {
	            String dongCode = rs.getString(1);
	            String sidoName = rs.getString(2);
	            String gugunName = rs.getString(3);
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
	public List<HouseDealDto> searchByAptNo(long aptNo, int year, int month) {
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
