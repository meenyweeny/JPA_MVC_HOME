package com.ssafy.service.user;

import java.util.ArrayList;
import java.util.Optional;

import com.ssafy.dao.user.UserDao;
import com.ssafy.dao.user.UserDaoImpl;
import com.ssafy.dto.user.User;

public class UserServiceImpl implements UserService {
	
	UserDao dao;
	
	public UserServiceImpl() {
		dao = new UserDaoImpl();
	}

	@Override
	public ArrayList<User> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Optional<User> selectUserByUserId(String userId) {
		return dao.selectUserByUserId(userId);
	}

	@Override
	public void insert(User user) {
		dao.insert(user);
	}

	@Override
	public void update(User user) {
		dao.update(user);
	}

	@Override
	public void deleteByUserId(String userId) {
		dao.deleteByUserId(userId);
	}

}
