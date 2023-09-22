package com.ssafy.dao.user;

import java.util.ArrayList;
import java.util.Optional;

import com.ssafy.dto.user.User;

public interface UserDao {
	
	public ArrayList<User> selectAll();
	public Optional<User> selectUserByUserId(String userId);
	public void insert(User user);
	public void update(User user);
	public void deleteByUserId(String userId);
}
