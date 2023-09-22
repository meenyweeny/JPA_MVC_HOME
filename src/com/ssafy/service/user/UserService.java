package com.ssafy.service.user;

import java.util.*;

import com.ssafy.dto.user.User;

public interface UserService {
	
	public ArrayList<User> selectAll();
	public Optional<User> selectUserByUserId(String userId);
	public void insert(User user);
	public void update(User user);
	public void deleteByUserId(String userId);
}
